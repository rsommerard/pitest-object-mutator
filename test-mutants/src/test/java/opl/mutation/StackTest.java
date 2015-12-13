package opl.mutation;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void testTraceStringRtn() {
        Stack stack = new Stack();

        Assert.assertNotNull(stack);
        Assert.assertEquals("5World", stack.getTraceStringRtn());
    }
}
