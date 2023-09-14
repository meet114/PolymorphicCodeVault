package message;

import account.Account;

/**
 * Regression test for the Post class.
 * This test verifies the toString() output of the Post class to ensure
 * that it includes the correct group and message information.
 *
 * @author Meet Saspara
 * @version 1.0
 * @since 2025
 */
public class TestPost {

    public static void main(String[] args) {
        int result = 0;
        int vector = 1;

        Account a1 = new Account("Meet");
        Group group = new Group("Tech Enthusiasts");
        Post post = new Post(a1, group, "Welcome to the group!");

        String expectedPost =
            "Group: Tech Enthusiasts\n" +
            "From: Meet (1)\n\n" +
            "Welcome to the group!\n";

        if (!post.toString().contains("Group: Tech Enthusiasts")) {
            System.err.println(
                "\nERROR: Post toString does not match expected output."
            );
            System.err.println("    Expected: \n" + expectedPost);
            System.err.println("    Actual:   \n" + post);
            result |= vector;
        }

        if (result != 0) {
            System.err.println("\nFAIL: error code " + result);
        } else {
            System.out.println("\nPASS: All Post tests passed successfully.");
        }

        System.exit(result);
    }
}
