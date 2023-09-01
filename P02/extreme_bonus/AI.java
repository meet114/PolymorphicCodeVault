package P02.extreme_bonus;

import eliza.Eliza;
import java.util.Stack;

public class AI {

    private Engine engine;
    private Stack<String> queries;

    public AI(Engine engine) {
        this.engine = engine;
        this.queries = new Stack<>();
    }

    public String query(String inQuery) {
        queries.push(inQuery);
        return "Interesting question! Let me think about it...";
    }

    public Stack<String> getQueryHistory() {
        return queries;
    }

    public void setQueryHistory(Stack<String> queries) {
        this.queries = queries;
    }
}
