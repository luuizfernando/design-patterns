package structural.adapter;

import java.math.BigDecimal;

public class PayPalSDK {

    public void sendPayment(BigDecimal amount, String currency) {
        System.out.println("Processing payment of: " + amount + " " + currency);
    }

}