package message;

import account.Account;

/**
 * Regression test for the Post class.
 * This test verifies the toString() output of the Post class to ensure
 * that it includes the correct group and message information.
 *
 * @author Meetkumar Saspara
 * @version 1.0
 * @since 2025
 */
public class TestPost {

    public static void main(String[] args) {
        int result = 0;
        int vector = 1;
        String expected;

        Account a1 = new Account("Meet");
        Group group = new Group("Tech Enthusiasts");
        Post post = new Post(a1, group, "Welcome to the group!");

        expected =
            "Group: Tech Enthusiasts\nFrom: Meet (1)\n\nWelcome to the group!\n";

        if (!expected.equals(post.toString())) {
            System.err.println(
                "\nERROR: Post toString does not match expected output."
            );
            System.err.println("    Expected: \n" + expected);
            System.err.println("    Actual:   \n" + post);
            result |= vector;
        }

        if (result != 0) {
            System.err.println("\nFAIL: error code " + result);
        }

        System.exit(result);
    }
}
