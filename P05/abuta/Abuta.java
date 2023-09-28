package abuta;

import account.*;
import java.util.ArrayList;
import java.util.List;
import menu.*;
import message.*;

public class Abuta {

    private List<Account> accounts;
    private List<Group> groups;
    private Message message;
    private Menu menu;
    private String output;
    private boolean running;

    public Abuta() {
        this.running = true;
        this.output = "";

        this.accounts = new ArrayList<>();
        this.groups = new ArrayList<>();

        accounts.add(new Account("Meet"));
        accounts.add(new Account("Jay"));
        accounts.add(new Account("Manit"));
        accounts.add(new Account("Ved"));
        accounts.add(new Account("Prof Rice"));

        groups.add(new Group("Gaming Legends"));
        groups.add(new Group("Science Wizards"));
        groups.add(new Group("Movie Buffs"));
        groups.add(new Group("Music Maestros"));
        groups.add(new Group("Tech Enthusiasts"));

        this.message =
            new Post(accounts.get(0), groups.get(0), "Welcome to the group!");

        menu = new Menu();
        menu.addMenuItem(new MenuItem("Exit", this::endApp));
        menu.addMenuItem(new MenuItem("Show Reply", this::showReply));
        menu.addMenuItem(new MenuItem("Show Replied To", this::showRepliedTo));
        menu.addMenuItem(new MenuItem("Add Reply", this::reply));
    }

    public void mdi() {
        while (running) {
            System.out.println("=== abUTA Social Media ===");
            System.out.println(output);
            output = "";
            System.out.println("Current Message: \n" + message);

            System.out.println(menu);

            int choice = Menu.getInt("Choose an option:");
            menu.run(choice);
        }
    }

    private void showRepliedTo() {
        if (message.getRepliedTo() == null) {
            output = "No parent message.";
        } else {
            message = message.getRepliedTo();
        }
    }

    private void showReply() {
        int numReplies = message.getNumReplies();

        if (numReplies == 0) {
            output = "No replies available.";
            return;
        }

        if (numReplies == 1) {
            message = message.getReply(0);
            return;
        }

        int index = Menu.getInt(
            "Choose a reply (0 - " + (numReplies - 1) + "):"
        );

        if (index >= 0 && index < numReplies) {
            message = message.getReply(index);
        } else {
            output = "Invalid selection.";
        }
    }

    private void endApp() {
        running = false;
    }

    private void reply() {
        char type = Menu.getChar("Post (P) or Direct Message (D)?");

        int authorIndex = Menu.selectItemFromList("Select Author:", accounts);
        if (authorIndex < 0 || authorIndex >= accounts.size()) {
            output = "Invalid selection.";
            return;
        }
        Account author = accounts.get(authorIndex);

        Message newMessage;
        String body;

        if (type == 'P' || type == 'p') {
            int groupIndex = Menu.selectItemFromList("Select Group:", groups);
            if (groupIndex < 0 || groupIndex >= groups.size()) {
                output = "Invalid selection.";
                return;
            }
            Group group = groups.get(groupIndex);

            body = Menu.getString("Enter message:").trim();
            if (body.isEmpty()) {
                output = "Message cannot be empty.";
                return;
            }

            newMessage = new Post(author, group, body);
        } else {
            int recipientIndex = Menu.selectItemFromList(
                "Select Recipient:",
                accounts
            );
            if (recipientIndex < 0 || recipientIndex >= accounts.size()) {
                output = "Invalid selection.";
                return;
            }
            Account recipient = accounts.get(recipientIndex);

            body = Menu.getString("Enter message:").trim();
            if (body.isEmpty()) {
                output = "Message cannot be empty.";
                return;
            }

            newMessage = new DirectMessage(author, recipient, body);
        }

        output = "Reply added successfully.";
    }

    public static void main(String[] args) {
        new Abuta().mdi();
    }
}
