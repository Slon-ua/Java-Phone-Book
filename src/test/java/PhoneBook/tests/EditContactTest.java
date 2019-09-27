package PhoneBook.tests;

import PhoneBook.PhoneBookFunction.AddContact;
import PhoneBook.PhoneBookFunction.LoadContacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class EditContactTest {

    Map<String, List<String>> contacts = new TreeMap<>();
    Scanner input = new Scanner(System.in);
    LoadContacts loadContacts = new LoadContacts();
    AddContact addContact = new AddContact();

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
    void canAddNewContact() {
        log.info("About to check condition - Add new contact");
        assert (contacts.size()>0);
        int size = contacts.size();
        int number = 123+size;
        String name = "xName"+size;
        addContact.addContactNameNumber(contacts,name, String.valueOf(number));
        assert (contacts.size() == size+1);
    }
}
