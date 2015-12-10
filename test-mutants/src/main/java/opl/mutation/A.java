package opl.mutation;

public class A {

    public static int staticInt = 42;
    private String mNotAStaticString = "I'm not static";

    public int getInteger() {
        return A.staticInt;
    }

    public String getMemberString() {
        return mNotAStaticString;
    }
}
