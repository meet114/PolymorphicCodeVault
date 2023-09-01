package P02.extreme_bonus;

import eliza.Eliza;
import java.util.Stack;

public class AI {

    private Engine engine;
    private Stack<String> queries;
    private Eliza eliza;

    public AI(Engine engine) {
        this.engine = engine;
        this.queries = new Stack<>();
        if (engine == Engine.ELIZA) {
            this.eliza = new Eliza();
            System.out.println(eliza.processInput(eliza.welcome));
        }
    }

    public String query(String inQuery) {
        queries.push(inQuery);
        if (eliza != null) {
            return eliza.processInput(inQuery);
        }
        return "Interesting question! Let me think about it...";
    }

    public Stack<String> getQueryHistory() {
        return queries;
    }

    public void setQueryHistory(Stack<String> queries) {
        this.queries = queries;
    }

    public boolean isFinished() {
        return eliza != null && eliza.finished();
    }
}
