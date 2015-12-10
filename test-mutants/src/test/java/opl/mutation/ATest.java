package opl.mutation;

import org.junit.Assert;
import org.junit.Test;

public class ATest {

    @Test
    public void testGetInteger() {
        A a = new A();

        Assert.assertEquals(42, a.getInteger());
    }

    @Test
    public void testGetMemberString() {
        A a = new A();

        Assert.assertEquals("I'm not static", a.getMemberString());
    }
}
