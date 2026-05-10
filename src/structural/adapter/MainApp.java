package structural.adapter;

import java.math.BigDecimal;

public class MainApp {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        PaymentAdapter demo = new DemoPaymentProcessor();
        service.processPayment(demo, new BigDecimal("100.00"));

        System.out.println();

        PaymentAdapter payPal = new PayPalAdapter(new PayPalSDK());
        service.processPayment(payPal, new BigDecimal("125.00"));

        PaymentAdapter stripe = new StripeAdapter(new StripeSDK());
        service.processPayment(stripe, new BigDecimal("150.00"));
    }
}