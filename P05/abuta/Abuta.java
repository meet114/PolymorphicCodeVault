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
    }
}
