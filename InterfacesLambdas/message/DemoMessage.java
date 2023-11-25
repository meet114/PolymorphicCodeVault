package message;

import account.Account;
import account.AccountStatus;
import java.util.ArrayList;

public class DemoMessage {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Meet"));
        accounts.add(new Account("Jay"));
        accounts.add(new Account("Manit"));
        accounts.add(new Account("Manan"));
        accounts.add(new Account("Ved"));

        System.out.println("Here are 5 accounts for the demo.");
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

        System.out.println("\n===");
        Message m4 = new Message(
            accounts.get(3),
            m3,
            "Artificial Intelligence is advancing rapidly!"
        );
        System.out.println(m4);

        System.out.println("\n===");
        Message m5 = new Message(
            accounts.get(4),
            m4,
            "AI is powerful, but we must also consider ethical concerns."
        );
        System.out.println(m5);

        System.out.println("\nStarting a second discussion thread:\n===");
        Message m6 = new Message(
            accounts.get(2),
            null,
            "What are your thoughts on Quantum Computing?"
        );
        System.out.println(m6);

        System.out.println("\n===");
        Message m7 = new Message(
            accounts.get(4),
            m6,
            "Quantum Computing could revolutionize cryptography."
        );
        System.out.println(m7);

        System.out.println("\n===");
        Message m8 = new Message(
            accounts.get(1),
            m7,
            "But it’s still in the early stages of development."
        );
        System.out.println(m8);

        System.out.println("\n===");
        Message m9 = new Message(
            accounts.get(3),
            m6,
            "I believe Quantum Computing and AI together could be game-changing."
        );
        System.out.println(m9);

        System.out.println("\n===");
        Message m10 = new Message(
            accounts.get(0),
            null,
            "This is an isolated message with no replies."
        );
        System.out.println(m10);

        System.out.println("\nTest case execution completed.");
    }
}
