package java16_practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TeeingTest {
    Teeing sut = new Teeing();

    @Test
    public void testTeeing(){
        int result = sut.teeing();
        Assertions.assertEquals(3, result);
    }
}