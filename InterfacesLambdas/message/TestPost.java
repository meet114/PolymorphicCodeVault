package message;

import account.Account;

/**
 * Regression test for the Post class.
 * This test verifies the toString() output of the Post class to ensure
 * that it includes the correct group and message information.
 *
 * Note: The method {@code stripDate} was inspired by {@code TestMessage} by Professor George F. Rice.
 *
 * @author Meetkumar Saspara
 * @version 1.1
 * @since 2025
 */
public class TestPost {

    private static String stripDate(Message m) {
        String s = m.toString();
        return s.replaceAll("(?m)^Date:.*\\n", "");
    }

    public static void main(String[] args) {
        int result = 0;
        int vector = 1;
        String expected;

        Account a1 = new Account("Meet");
        Group group = new Group("Tech Enthusiasts");
        Post post = new Post(a1, group, "Welcome to the group!");

        expected =
            "Group: Tech Enthusiasts\nFrom: Meet (1)\n\nWelcome to the group!\n";

        if (!expected.equals(stripDate(post))) {
            System.err.println(
                "\nERROR: Post toString does not match expected output."
            );
            System.err.println("    Expected: \n" + expected);
            System.err.println("    Actual:   \n" + stripDate(post));
            result |= vector;
        }

        if (result != 0) {
            System.err.println("\nFAIL: error code " + result);
        }

        System.exit(result);
    }
}
