package java10_practice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionalClassTest {
    OptionalClass sut = new OptionalClass();

    @Test
    public void testOptional(){
        assertArrayEquals(sut.optional().toArray(), List.of("String").toArray());
    }

}