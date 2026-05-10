package structural.adapter;

import java.math.BigDecimal;

public class StripeAdapter implements PaymentAdapter {

    private StripeSDK stripeSDK;
    public StripeAdapter(StripeSDK stripeSDK) {
        this.stripeSDK = stripeSDK;
    }

    @Override
    public void pay(BigDecimal amount) {
        BigDecimal scaled = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        long cents = scaled.movePointRight(2).longValueExact();

        System.out.println("Converting " + scaled + " to " + cents + " cents for Stripe");
        stripeSDK.makePayment(cents);
    }

}