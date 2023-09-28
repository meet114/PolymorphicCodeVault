package message;

import account.Account;

/**
 * Regression test for the DirectMessage class.
 * This test verifies the toString() output of the DirectMessage class to ensure
 * that it includes the correct recipient and message information.
 *
 * Note: The method {@code stripDate} was inspired by {@code TestMessage} by Professor George F. Rice.
 *
 * @author Meetkumar Saspara
 * @version 1.1
 * @since 2025
 */
public class TestDirectMessage {

    private static String stripDate(Message m) {
        String s = m.toString();
        return s.replaceAll("(?m)^Date:.*\\n", "");
    }

    public static void main(String[] args) {
        int result = 0;
        int vector = 1;
        String expected;

        Account a1 = new Account("Meet");
        Account a2 = new Account("Jay");
        DirectMessage dm = new DirectMessage(a1, a2, "Hi Jay, how are you?");

        expected = "To: Jay (2)\nFrom: Meet (1)\n\nHi Jay, how are you?\n";

        if (!expected.equals(stripDate(dm))) {
            System.err.println(
                "\nERROR: DirectMessage toString does not match expected output."
            );
            System.err.println("    Expected: \n" + expected);
            System.err.println("    Actual:   \n" + stripDate(dm));
            result |= vector;
        }

        if (result != 0) {
            System.err.println("\nFAIL: error code " + result);
        }

        System.exit(result);
    }
}
