package opl.mutation;

import org.junit.Assert;
import org.junit.Test;

public class TraceTest {

    @Test
    public void testTraceIntString() {
        Trace trace = new Trace();
        int a = 5;
        String b = "Foo";

        Assert.assertEquals("5Foo", trace.trace(a, b));
    }

    @Test
    public void testTraceInt() {
        Trace trace = new Trace();
        int a = 5;

        Assert.assertEquals("5", trace.trace(a));
    }
}
