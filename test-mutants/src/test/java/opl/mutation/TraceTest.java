package opl.mutation;

import org.junit.Assert;
import org.junit.Test;

public class TraceTest {

    @Test
    public void testTraceIntObjectString() {
        Trace trace = new Trace();
        int a = 3;
        Object b = new Object();
        String c = new String();

        Assert.assertEquals("int:Object:String", trace.trace(a, b, c));
    }

    @Test
    public void testTraceIntStringString() {
        Trace trace = new Trace();
        int a = 3;
        String b = new String();
        String c = new String();

        Assert.assertEquals("int:String:String", trace.trace(a, b, c));
    }

    @Test
    public void testTraceObjectString() {
        Trace trace = new Trace();
        Object a = new Object();
        String b = new String();

        Assert.assertEquals("Object:String", trace.trace(a, b));
    }

    @Test
    public void testTraceStringString() {
        Trace trace = new Trace();
        String a = new String();
        String b = new String();

        Assert.assertEquals("String:String", trace.trace(a, b));
    }
}
