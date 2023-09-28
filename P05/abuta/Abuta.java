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

    private void endApp() {
        running = false;
    }

    private void showRepliedTo() {}

    private void showReply() {}

    private void reply() {}
}
