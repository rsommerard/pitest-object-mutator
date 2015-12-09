package opl.mutation;

import opl.mutation.BusinessLogic;
import org.junit.Assert;
import org.junit.Test;

public class BusinessLogicTest {

    @Test
    public void testNormalPricing() {
        BusinessLogic businessLogic = new BusinessLogic();

        // Not enough for discount:
        int amount = 1;
        Assert.assertEquals(17, businessLogic.getPrice(amount, false));
    }

    @Test
    public void testDiscountPricingByAmount() {
        BusinessLogic businessLogic = new BusinessLogic();

        //Enough for discount:
        int amount = 100;
        Assert.assertEquals(1500, businessLogic.getPrice(amount, false));
    }

    @Test
    public void testDiscountWithCoupon() {
        BusinessLogic businessLogic = new BusinessLogic();

        //Not enough for discount, but coupon:
        int amount = 1;
        Assert.assertEquals(15, businessLogic.getPrice(amount, true));
    }

    @Test
    public void testDiscountAmountCornerCase() {
        BusinessLogic businessLogic = new BusinessLogic();

        //Just enough for discount, mutation info > should fail this test
        int amount = 20;
        Assert.assertEquals(300, businessLogic.getPrice(amount, false));
    }
}
