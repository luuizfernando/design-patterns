package structural.bridge;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *  A concrete implementor for processing payments in USD
 */
public class UsdCurrencyProcessor implements CurrencyProcessor {

    @Override
    public void pay(BigDecimal amount) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("USD payment of " + numberFormat.format(amount));
    }

}