import java.util.ArrayList;

public class DemoMessage {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Meet"));
        accounts.add(new Account("Jay"));
        accounts.add(new Account("Manit"));

        System.out.println("Here are 3 accounts for the demo.");
        System.out.println(
            "The user name is followed by the account number in parentheses.\n"
        );
        for (Account a : accounts) System.out.println(a);

        System.out.println("\nThis first message starts a new thread:\n===");
        Message m1 = new Message(
            accounts.get(0),
            null,
            "Hello! Let's start a discussion."
        );
        System.out.println(m1);

        System.out.println("\nThis leads to a response:\n===");
        Message m2 = new Message(
            accounts.get(1),
            m1,
            "Sounds great! What's the topic?"
        );
        System.out.println(m2);

        System.out.println("\n===");
        Message m3 = new Message(
            accounts.get(2),
            m2,
            "I think we should talk about emerging technologies."
        );
        System.out.println(m3);
    }
}
