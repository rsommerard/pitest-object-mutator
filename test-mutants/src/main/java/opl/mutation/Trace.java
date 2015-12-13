package opl.mutation;

public class Trace {

    public String trace(int level, String className) {
        return String.valueOf(level) + className;
    }

    public String trace(int level) {
        return String.valueOf(level);
    }
}
