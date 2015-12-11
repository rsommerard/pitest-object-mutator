package opl.mutation;

public class Trace {

    public String trace(int level, Object obj, String traceText) {
        return "int:Object:String";
    }

    public String trace(int level, String className, String traceText) {
        return "int:String:String";
    }

    public String trace(Object obj, String traceText) {
        return "Object:String";
    }

    public String trace(String className, String traceText) {
        return "String:String";
    }
}
