package opl.mutation;

import org.junit.Assert;
import org.junit.Test;

public class ATest {

    @Test
    public void testNormalPricing() {
        A a = new A();

        Assert.assertEquals(5, a.getInteger());
    }
}
