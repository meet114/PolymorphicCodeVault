package P02.extreme_bonus;

import java.util.Scanner;

public class Query {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(" AI engines can be use are:");
            for (Engine engine : Engine.values()) {
                System.out.println(engine);
            }
            System.out.println(
                "Engines can be run after: java P02.extreme_bonus.Query <Engine_name>"
            );
            return;
        }
        String engineOn = args[0].toUpperCase();
        boolean weHaveEngine = false;

        for (Engine engine : Engine.values()) {
            if (engine.name().equals(engineOn)) {
                weHaveEngine = true;
            }
        }
        if (weHaveEngine == false) {
            System.out.println("Sorry we don't have " + engineOn);
            System.out.println("but you can use:");
            for (Engine engine : Engine.values()) {
                System.out.println(engine);
            }
            return;
        }
        Engine engineRunning = Engine.valueOf(engineOn);
        AI ai = new AI(engineRunning);
        Scanner input = new Scanner(System.in);
        System.out.println(engineOn + " Activated Ask anything :");
        while (input.hasNextLine()) {
            String userQuery = input.nextLine();
            System.out.println(ai.query(userQuery));
        }
        input.close();
        System.out.println("All Recent queries: ");
        for (String query : ai.getQueryHistory()) {
            System.out.println(query);
        }
    }
}
