package structural.bridge;

import java.math.BigDecimal;

/**
 *  A refined abstraction for handling credit card payments
 */
public class CreditCardPayment  extends Payment{

    public CreditCardPayment(CurrencyProcessor currencyProcessor) {
        super(currencyProcessor);
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("--- BEGIN: Credit Card Transaction ---");

        authorizeCreditCard();

        // Delegate the implementation-specific logic to the CurrencyProcessor
        // This is the bridge in action
        currencyProcessor.pay(amount);

        System.out.println("--- END: Credit Card Transaction ---");
    }

    private void authorizeCreditCard() {
        System.out.println("[CreditCardPayment] Contacting payment gateway to authorization...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("[CreditCardPayment] Card authorized");
    }

}