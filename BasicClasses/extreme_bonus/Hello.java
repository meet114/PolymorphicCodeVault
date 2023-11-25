public class Hello {

    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        String name = System.getProperty("user.name");

        System.out.println();
        System.out.println("Hello, " + name);
    }
}
