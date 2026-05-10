package structural.adapter;

import java.math.BigDecimal;

public class PaymentService {

    public void processPayment(PaymentAdapter paymentAdapter, BigDecimal amount) {
        paymentAdapter.pay(amount);
    }

}