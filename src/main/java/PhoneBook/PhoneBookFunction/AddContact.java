package PhoneBook.PhoneBookFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddContact {
    SaveContacts saveContacts = new SaveContacts();

    public void addContact(Map<String, List<String>> contacts, Scanner input) {
        System.out.println("You are about to add a new contact to the phone book.");
        String name;
        String number;

        while (true) {
            System.out.println("Enter contact name:");
            name = input.nextLine().trim();
            if (name.matches("^.{2,50}$")) {
                break;
            } else {
                System.out.println("Name must be in range 2 - 50 symbols.");
            }
        }

        while (true) {
            System.out.println("Enter contact number:");
            number = input.nextLine().trim();
            if (number.matches("^\\+?[0-9 ]{3,25}$")) {
                break;
            } else {
                System.out.println("Number may contain only '+', spaces and digits. Min length 3, max length 25.");
            }
        }
    }

    public void addContactNameNumber(Map<String, List<String>> contacts, String name, String number){
        if (contacts.containsKey(name)) {
            System.out.printf("'%s' already exists in the phone book!\n", name);

            if (contacts.get(name).contains(number)) {
                System.out.printf("Number %s already available for contact '%s'.\n", number, name);
            } else {
                contacts.get(name).add(number);
                saveContacts.saveContacts(contacts);
                System.out.printf("Successfully added number %s for contact '%s'.\n", number, name);
            }

        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            contacts.put(name, numbers);
            saveContacts.saveContacts(contacts);
            System.out.printf("Successfully added contact '%s' !\n", name);
        }

    }

}
