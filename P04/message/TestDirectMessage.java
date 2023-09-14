package message;

import account.Account;

/**
 * Regression test for the DirectMessage class.
 * This test verifies the toString() output of the DirectMessage class to ensure
 * that it includes the correct recipient and message information.
 *
 * @author Meet Saspara
 * @version 1.0
 * @since 2025
 */
public class TestDirectMessage {

    public static void main(String[] args) {
        int result = 0;
        int vector = 1;

        Account a1 = new Account("Meet");
        Account a2 = new Account("Jay");
        DirectMessage dm = new DirectMessage(a1, a2, "Hi Jay, how are you?");

        String expectedDM =
            "To: Jay (2)\n" + "From: Meet (1)\n\n" + "Hi Jay, how are you?\n";

        if (!dm.toString().contains("To: Jay (2)")) {
            System.err.println(
                "\nERROR: DirectMessage toString does not match expected output."
            );
            System.err.println("    Expected: \n" + expectedDM);
            System.err.println("    Actual:   \n" + dm);
            result |= vector;
        }

        if (result != 0) {
            System.err.println("\nFAIL: error code " + result);
        } else {
            System.out.println(
                "\nPASS: All DirectMessage tests passed successfully."
            );
        }

        System.exit(result);
    }
}
