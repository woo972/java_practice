package java9_practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessHandleClassTest {

    ProcessHandleClass sut = new ProcessHandleClass();

    @Test
    public void testPid(){
        // 테스트를 수행하면 프로세스가 새로 생겨서 수행된다
        System.out.println(sut.getCurrentPid());
        Assertions.assertNotEquals(sut.getCurrentPid(), 0);
    }

    @Test
    public void testAlive(){
        Assertions.assertTrue(sut.isCurrentAlive());
    }
}