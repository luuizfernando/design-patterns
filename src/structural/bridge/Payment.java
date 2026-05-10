package structural.bridge;

import structural.adapter.PaymentAdapter;

import java.math.BigDecimal;

/**
 * Abstração do Bridge
 *
 * Define a interface de alto nível
 * Mantém uma referência ao objeto Implementador
 */
public abstract class Payment {

    // O "Implementador" - esta é a ponte para a implementação abaixo
    protected CurrencyProcessor currencyProcessor;

    public Payment(CurrencyProcessor currencyProcessor) {
        this.currencyProcessor = currencyProcessor;
    }

    // Operação de alto nível definida pela abstração
    public abstract void pay(BigDecimal amount);

}