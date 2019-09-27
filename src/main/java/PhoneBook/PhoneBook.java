package PhoneBook;

import PhoneBook.PhoneBookFunction.*;

public class PhoneBook {

    public static final String DATA_PATH = "src/main/java/PhoneBook/contacts.csv";
    public static void main(String[] args) {
        StartPhoneBookApp startPhoneBookApp = new StartPhoneBookApp();
        startPhoneBookApp.startPhoneBookApp();
    }
}

