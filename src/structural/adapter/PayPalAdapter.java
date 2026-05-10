package structural.adapter;

import java.math.BigDecimal;

public class PayPalAdapter implements PaymentAdapter {

    private PayPalSDK payPalSDK;

    public PayPalAdapter(PayPalSDK payPalSDK) {
        this.payPalSDK = payPalSDK;
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("[PayPalAdapter] paying amount: " + amount);
        payPalSDK.sendPayment(amount, "USD");
    }

}