package opl.mutation;

public class Stack {

    private String traceRtn;

    public Stack() {
        Trace t = new Trace();

        traceRtn = t.trace(5, "Hello", "World");
    }
}
