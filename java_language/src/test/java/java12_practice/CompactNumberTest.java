package java12_practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

class CompactNumberTest {

    CompactNumber sut = new CompactNumber();

    @Test
    public void shortStyleUS(){
        //given
        long number = 1_000_000;
        Locale locale = Locale.US;
        NumberFormat.Style style = NumberFormat.Style.SHORT;
        //when
        String result = sut.formatCompact(number, locale, style);
        //then
        Assertions.assertEquals(result, "1M");
    }

    @Test
    public void shortStyleKor(){
        //given
        long number = 1_000_000;
        Locale locale = Locale.KOREA;
        NumberFormat.Style style = NumberFormat.Style.SHORT;
        //when
        String result = sut.formatCompact(number, locale, style);
        //then
        Assertions.assertEquals(result, "100만");
    }

    @Test
    public void currencyFormatUS(){
        //given
        long number = 1_000_000;
        Locale locale = Locale.US;
        //when
        String result = sut.formatCurrency(number, locale);
        //then
        Assertions.assertEquals(result, "$1,000,000.00");
    }



    @Test
    public void currencyFormatKor(){
        //given
        long number = 1_000_000;
        Locale locale = Locale.KOREA;
        //when
        String result = sut.formatCurrency(number, locale);
        //then
        Assertions.assertEquals(result, "₩1,000,000");
    }

    @Test
    public void forceTest(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        Currency currency = numberFormat.getCurrency();
        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getDefaultFractionDigits());
        System.out.println(currency.getNumericCode());
        System.out.println(currency.getSymbol(Locale.US));


        System.out.println("--------------");
        numberFormat = NumberFormat.getCompactNumberInstance(Locale.KOREA, NumberFormat.Style.LONG);
        System.out.println(numberFormat.format(123456789.123456789));
        System.out.println(numberFormat.getMaximumFractionDigits());
        System.out.println("----");

        numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        currency = numberFormat.getCurrency();
        System.out.println(currency.getDisplayName(Locale.US));
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getDefaultFractionDigits());
        System.out.println(currency.getNumericCode());
        System.out.println(currency.getSymbol(Locale.US));
        ;
    }
}