package structural.adapter;

import java.math.BigDecimal;

public class DemoPaymentProcessor implements PaymentAdapter {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paying " + amount);
    }

}