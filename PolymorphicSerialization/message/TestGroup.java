package message;

public class TestGroup {

    public static void main(String[] args) {
        int result = 0;
        int vector = 1;
        String expected = "";

        Group g1 = new Group("Study Group");
        expected = "Study Group";
        if (!expected.equals(g1.toString())) {
            System.err.println("\nERROR: Constructor or toString failed");
            System.err.println("    Expected: " + expected);
            System.err.println("    Actual:   " + g1);
            result |= vector;
        }
        vector <<= 1;

        if (!g1.isActive()) {
            System.err.println(
                "\nERROR: Newly constructed group should be active"
            );
            System.err.println("    Expected: true");
            System.err.println("    Actual:   " + g1.isActive());
            result |= vector;
        }
        vector <<= 1;

        g1.disable();
        if (g1.isActive()) {
            System.err.println(
                "\nERROR: Group should be inactive after calling disable"
            );
            System.err.println("    Expected: false");
            System.err.println("    Actual:   " + g1.isActive());
            result |= vector;
        }
        vector <<= 1;

        expected = "Study Group [inactive]";
        if (!expected.equals(g1.toString())) {
            System.err.println(
                "\nERROR: toString should show [inactive] for disabled group"
            );
            System.err.println("    Expected: " + expected);
            System.err.println("    Actual:   " + g1);
            result |= vector;
        }
        vector <<= 1;

        g1.enable();
        if (!g1.isActive()) {
            System.err.println(
                "\nERROR: Group should be active after calling enable"
            );
            System.err.println("    Expected: true");
            System.err.println("    Actual:   " + g1.isActive());
            result |= vector;
        }
        expected = "Study Group";
        if (!expected.equals(g1.toString())) {
            System.err.println(
                "\nERROR: toString should not show [inactive] after enabling"
            );
            System.err.println("    Expected: " + expected);
            System.err.println("    Actual:   " + g1);
            result |= vector;
        }
        vector <<= 1;

        if (result != 0) System.err.println("\nFAIL: error code " + result);
        System.exit(result);
    }
}
