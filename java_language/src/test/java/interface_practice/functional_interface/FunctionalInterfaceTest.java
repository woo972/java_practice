package interface_practice.functional_interface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalInterfaceTest {

    @Test
    public void testPredicate(){
        String input = "test1pass1FAIL";
        FunctionalInterface functionalInterface = new FunctionalInterface();
        assertTrue(functionalInterface.hasTestAndPassButFail(input));
    }

    @Test
    public void testFunction(){
        int input = 1000;
        FunctionalInterface functionalInterface = new FunctionalInterface();
        Assertions.assertEquals(functionalInterface.quotedNumber(input), "'1000'");
    }

    @Test
    public void testOperator(){
        FunctionalInterface functionalInterface = new FunctionalInterface();
        Assertions.assertEquals(functionalInterface.add1(), 10
        );
    }
}