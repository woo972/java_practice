package java12_practice;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumber {

    public String formatCompact(long inputNumber, Locale locale, NumberFormat.Style style) {
        NumberFormat numberformat = NumberFormat.getCompactNumberInstance(locale, style);
        return numberformat.format(inputNumber);
    }

    public String formatCurrency(long inputNumber, Locale locale) {
        NumberFormat numberformat = NumberFormat.getCurrencyInstance(locale);
        return numberformat.format(inputNumber);
    }
}
