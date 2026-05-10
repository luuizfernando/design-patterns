package structural.bridge;

import java.math.BigDecimal;

public class NetBankingPayment extends Payment {

    public NetBankingPayment(CurrencyProcessor currencyProcessor) {
        super(currencyProcessor);
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("--- BEGIN: Net Banking Transaction ---");

        connectToBankApi();

        // Delega a lógica de implementação para CurrencyProcessor
        currencyProcessor.pay(amount);

        System.out.println("--- END: Net Banking Transaction ---");
    }

    private void connectToBankApi() {
        System.out.println("[NetBankingPayment] Connecting to Bank API...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("[NetBankingPayment] Connection successful");
    }

}