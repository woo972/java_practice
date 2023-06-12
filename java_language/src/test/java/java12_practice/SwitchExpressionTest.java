package java12_practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchExpressionTest {

    SwitchExpression sut = new SwitchExpression();
    @Test
    public void testArrowExpression(){
        // given
        // when
        int result = sut.arrowExpression();
        // then
        Assertions.assertEquals(result, 3);
    }


}