package structural.adapter;

import java.math.BigDecimal;

public interface PaymentAdapter {

    void pay(BigDecimal amount);

}