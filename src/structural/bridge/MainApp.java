package structural.bridge;

import java.math.BigDecimal;

public class MainApp {
    public static void main(String[] args) {

        // Combination 01 - Net Banking payment (Abstraction) in EUR (Implementation)
        Payment eurPayment = new NetBankingPayment(new EurCurrencyProcessor());
        eurPayment.pay(new BigDecimal("200.00"));

        System.out.println();

        // Combination 01 - Credit Card payment (Abstraction) in USD (Implementation)
        Payment usdPayment = new CreditCardPayment(new UsdCurrencyProcessor());
        usdPayment.pay(new BigDecimal("400.00"));

    }
}