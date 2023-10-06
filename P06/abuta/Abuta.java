package abuta;

import account.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import menu.*;
import message.*;

/**
 * The {@code Abuta} class serves as the main controller for the abUTA social media application.
 * It manages user accounts, groups, and the message tree. This class provides an interactive menu
 * with options to navigate and update the message tree (add replies, show parent/child messages),
 * modify account and group statuses, and perform file I/O operations (save, save as, open, and reset
 * the message tree via newAbuta()).
 *
 * <p>The class follows the encapsulated save/open pattern where each data class (Account, Group,
 * Message, Post, DirectMessage) is responsible for saving and restoring its own state.
 * The menu options are built using the {@code Menu} and {@code MenuItem} classes.
 *
 * @author Meetkumar Saspara
 * @version 1.0
 * @since 2025
 */
public class Abuta {

    private List<Account> accounts;
    private List<Group> groups;
    private Message message;
    private Menu menu;
    private String output;
    private boolean running;
    private String filename = "default.txt";

    /**
     * Constructs a new Abuta application.
     * <p>
     * Initializes the accounts, groups, and creates an initial message.
     * It also sets up the menu with options including exit, navigation,
     * adding replies/accounts/groups, muting accounts, toggling group status,
     * and file I/O operations (newAbUTA, save, saveAs, open).
     */
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

        // Create the initial message.
        this.message =
            new Post(accounts.get(0), groups.get(0), "Welcome to the group!");

        menu = new Menu();
        menu.addMenuItem(new MenuItem("Exit", this::endApp));
        menu.addMenuItem(new MenuItem("Show Reply", this::showReply));
        menu.addMenuItem(new MenuItem("Show Replied To", this::showRepliedTo));
        menu.addMenuItem(new MenuItem("Add Reply", this::reply));

        menu.addMenuItem(new MenuItem("Add Account", this::addAccount));
        menu.addMenuItem(new MenuItem("Add Group", this::addGroup));

        menu.addMenuItem(
            new MenuItem("Mute/Unmute Account", this::toggleMuteAccount)
        );
        menu.addMenuItem(
            new MenuItem("Enable/Disable Group", this::toggleGroupStatus)
        );

        menu.addMenuItem(new MenuItem("New abUTA", this::newAbuta));
        menu.addMenuItem(new MenuItem("Save", this::save));
        menu.addMenuItem(new MenuItem("Save As", this::saveAs));
        menu.addMenuItem(new MenuItem("Open", this::open));
    }

    /**
     * Starts the main display loop of the application.
     * <p>
     * Continuously displays the menu and processes user input until the application is terminated.
     */
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

    /**
     * Displays the parent message of the current message.
     * If there is no parent message, sets output to indicate that.
     */
    private void showRepliedTo() {
        if (message.getRepliedTo() == null) {
            output = "No parent message.";
        } else {
            message = message.getRepliedTo();
        }
    }

    /**
     * Displays one of the replies to the current message.
     * If there is exactly one reply, that reply is shown;
     * if there are multiple replies, the user is prompted to choose one.
     */
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

    /**
     * Terminates the application.
     */
    private void endApp() {
        running = false;
    }

    /**
     * Prompts the user to add a new reply to the current message.
     * Depending on the user's input, a new Post or DirectMessage is created.
     * <p>
     * If the user chooses a Post, they must select an author and group and enter a message.
     * If the user chooses a DirectMessage, they must select an author and recipient and enter a message.
     * The new reply is then attached to the current message.
     */
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

            // Create a new Post; if your UML specifies linking replies,
            // you may need to pass the current message as the repliedTo parameter.
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

    /**
     * Prompts the user to enter a new account name and adds the account to the system.
     */
    private void addAccount() {
        String name = Menu.getString("Enter new account name:").trim();
        if (name.isEmpty()) {
            output = "Account name cannot be empty.";
            return;
        }

        accounts.add(new Account(name));
        output = "Account '" + name + "' added successfully.";
    }

    /**
     * Prompts the user to enter a new group name and adds the group to the system.
     */
    private void addGroup() {
        String name = Menu.getString("Enter new group name:").trim();
        if (name.isEmpty()) {
            output = "Group name cannot be empty.";
            return;
        }

        groups.add(new Group(name));
        output = "Group '" + name + "' added successfully.";
    }

    /**
     * Toggles the mute status of an account selected by the user.
     */
    private void toggleMuteAccount() {
        int accountIndex = Menu.selectItemFromList(
            "Select an account to mute/unmute:",
            accounts
        );
        if (accountIndex < 0 || accountIndex >= accounts.size()) {
            output = "Invalid selection.";
            return;
        }

        Account selected = accounts.get(accountIndex);

        if (selected.isMuted()) {
            selected.setStatus(AccountStatus.Normal);
            output = "Account '" + selected.toString() + "' is now Unmuted.";
        } else {
            selected.setStatus(AccountStatus.Muted);
            output = "Account '" + selected.toString() + "' is now Muted.";
        }
    }

    /**
     * Toggles the active status of a group selected by the user.
     */
    private void toggleGroupStatus() {
        int groupIndex = Menu.selectItemFromList(
            "Select a group to enable/disable:",
            groups
        );
        if (groupIndex < 0 || groupIndex >= groups.size()) {
            output = "Invalid selection.";
            return;
        }

        Group selected = groups.get(groupIndex);

        if (!selected.isActive()) {
            selected.enable();
            output = "Group '" + selected.toString() + "' is now Enabled.";
        } else {
            selected.disable();
            output = "Group '" + selected.toString() + "' is now Disabled.";
        }
    }

    /**
     * Resets the current message to the root of the message tree.
     * <p>
     * Traverses upward using {@code getRepliedTo()} until the root is found.
     */
    public void newAbuta() {
        Message root = message;
        while (root.getRepliedTo() != null) {
            root = root.getRepliedTo();
        }
        message = root;
    }

    /**
     * Saves the current message tree to a file.
     * <p>
     * Uses a try-with-resources block to open a {@code BufferedWriter} using the current filename.
     * It finds the root message by traversing upward and then calls {@code save(BufferedWriter)}
     * on that root.
     */
    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            Message root = message;
            while (root.getRepliedTo() != null) {
                root = root.getRepliedTo();
            }
            root.save(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the current message tree to a new file.
     * <p>
     * Prompts the user for a new filename, updates the filename, and then calls {@code save()}.
     */
    public void saveAs() {
        String newFilename = Menu.getString("Enter new filename: ");
        if (newFilename != null && !newFilename.isEmpty()) {
            filename = newFilename;
            save();
        }
    }

    /**
     * Opens a file and loads the message tree from it.
     * <p>
     * Prompts the user for a filename, then uses a try-with-resources block to open a
     * {@code BufferedReader} with that filename and constructs a new {@code Post} (as the root message)
     * from the file.
     */
    public void open() {
        String fileToOpen = Menu.getString("Enter filename to open: ");
        if (fileToOpen != null && !fileToOpen.isEmpty()) {
            filename = fileToOpen;
            try (
                BufferedReader br = new BufferedReader(new FileReader(filename))
            ) {
                message = new Post(br, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The main method to start the abUTA Social Media application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new Abuta().mdi();
    }
}
