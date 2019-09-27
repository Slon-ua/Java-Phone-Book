package PhoneBook.PhoneBookFunction;

import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class DeleteContact {
    SaveContacts saveContacts = new SaveContacts();

    public void deleteContact(Map<String, List<String>> contacts, Scanner input) {

        System.out.println("Enter name of the contact to be deleted:");
        String name = input.nextLine().trim();

        if (contacts.containsKey(name)) {
            System.out.printf("Contact '%s' will be deleted. Are you sure? [Y/N]:\n", name);
            String confirmation = input.nextLine().trim().toLowerCase();
            confirm:
            while (true) {
                switch (confirmation) {
                    case "y":
                        deleteContactName(contacts,name);
                        break confirm;
                    case "n":
                        break confirm;
                    default:
                        System.out.println("Delete contact? [Y/N]:");
                        break;
                }
                confirmation = input.nextLine().trim().toLowerCase();
            }

        } else {
            System.out.println("Sorry, name not found!");
        }

        System.out.println();
        System.out.println("Type a command or 'exit' to quit. For a list of valid commands use 'help':");
    }

    public void deleteContactName(Map<String, List<String>> contacts, String name){
        contacts.remove(name);
        saveContacts.saveContacts(contacts);
        System.out.println("Contact was deleted successfully!");
    }
}
