package P02.full_credit;

public class AI {

    private Engine engine;
    private String[] queries;
    private final int querySize = 5;

    public AI(Engine engine) {
        this.engine = engine;
        this.queries = new String[querySize];
    }

    public String query(String inQuery) {
        for (int i = querySize - 1; i > 0; i++) {
            queries[i] = queries[i - 1];
        }
        queries[0] = inQuery;
        return "AI (" + engine + ") processed: '" + inQuery + "'.";
    }

    public String[] getQueryHistory() {
        return queries;
    }

    public void setQueryHistory(String[] queries) {
        this.queries = queries;
    }
}
