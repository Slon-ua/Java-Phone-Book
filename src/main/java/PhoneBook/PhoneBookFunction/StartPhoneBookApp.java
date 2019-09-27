package PhoneBook.PhoneBookFunction;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StartPhoneBookApp {
    public void startPhoneBookApp(){
        AddContact addContact = new AddContact();
        DeleteContact deleteContact = new DeleteContact();
        EditContact editContact = new EditContact();
        FindContact findContact = new FindContact();
        ListCommands listCommands = new ListCommands();
        ListContacts listContacts = new ListContacts();
        LoadContacts loadContacts = new LoadContacts();
        ShowContact showContact = new ShowContact();


        System.out.println("PHONE BOOK. Java-8");
        System.out.println("===========================");
        System.out.println("Type a command or 'exit' to quit:");
        listCommands.listCommands();
        System.out.print("> ");

        Map<String, List<String>> contacts = new TreeMap<>();
        loadContacts.loadContactsFromBook(contacts);
        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();

        while (!line.equals("exit")) {
            switch (line) {
                case "list":
                    listContacts.listContacts(contacts);
                    break;
                case "show":
                    showContact.showContact(contacts, input);
                    break;
                case "find":
                    findContact.findContact(contacts, input);
                    break;
                case "add":
                    addContact.addContact(contacts, input);
                    break;
                case "edit":
                    editContact.editContact(contacts, input);
                    break;
                case "delete":
                    deleteContact.deleteContact(contacts, input);
                    break;
                case "help":
                    listCommands.listCommands();
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }


            System.out.print("\n> ");
            line = input.nextLine().trim();
        }

        System.out.println("'Phone Book 0.2' terminated.");
    }

}

