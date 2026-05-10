package structural.bridge;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class EurCurrencyProcessor implements CurrencyProcessor {

    @Override
    public void pay(BigDecimal amount) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("EUR payment of: " + numberFormat.format(amount));
    }

}