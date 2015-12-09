package opl.mutation;

import org.junit.Assert;
import org.junit.Test;

public class BTest {

    @Test
    public void testNormalPricing() {
        B b = new B();

        Assert.assertEquals(10, b.getInteger());
    }
}
