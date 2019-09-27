package PhoneBook.PhoneBookFunction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import static PhoneBook.PhoneBook.DATA_PATH;

public class SaveContacts {
    public void saveContacts(Map<String, List<String>> contacts) {
        try (PrintWriter writer = new PrintWriter(DATA_PATH)) {
            if (!contacts.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
                    String line = String.format("%s,\"%s\"",
                            entry.getKey(), entry.getValue().toString().replaceAll("\\[|]", ""));
                    writer.println(line);
                }
            }

        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
    }
}
