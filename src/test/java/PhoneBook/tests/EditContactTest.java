package PhoneBook.tests;

import PhoneBook.PhoneBookFunction.AddContact;
import PhoneBook.PhoneBookFunction.DeleteContact;
import PhoneBook.PhoneBookFunction.LoadContacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



@Slf4j
public class EditContactTest {

    Map<String, List<String>> contacts = new TreeMap<>();
    Scanner input = new Scanner(System.in);
    LoadContacts loadContacts = new LoadContacts();
    AddContact addContact = new AddContact();
    DeleteContact deleteContact =new DeleteContact();

    private String[] validCredentials = { "name1", "12345"};

    @BeforeEach
    void canLoadContactsFromBook() {
        loadContacts.loadContactsFromBook(contacts);
    }

    @Test
    public void canCheckPhoneBookIsNotEmpty() {
        log.info("About to check condition - PhoneBook existing");
       assert (contacts.size()>0);
    }

    @Test
    void canAddNewContactWithValidCredentials() {
        log.info("About to check condition - Add new contact");
        assert (contacts.size()>0);
        int size = contacts.size();
        addContact.addContactNameNumber(contacts,this.validCredentials[0], this.validCredentials[1]);
        assert (contacts.size() == size+1);
    }
    @Test
    void canDeleteContactWithValidCredentials() {
        log.info("About to check condition - Delete contact");
        assert (contacts.size()>0);
        int size = contacts.size();
        deleteContact.deleteContactName(contacts,validCredentials[0]);
        assert (contacts.size() == --size);
    }
}
