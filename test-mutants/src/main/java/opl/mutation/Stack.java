package opl.mutation;

public class Stack {

    private String traceStringRtn;

    public Stack() {
        Trace t = new Trace();
        traceStringRtn = t.trace(5, "World");
    }

    public String getTraceStringRtn() {
        return this.traceStringRtn;
    }
}
