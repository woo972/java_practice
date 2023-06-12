package java9_practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class NewStreamAPITest {
    NewStreamAPI newStreamAPI = new NewStreamAPI();
    @Test
    public void testDropWhile(){
        // 3이상인 수가 있는 동안만 drop을 하는데, 첫 숫자부터 3 미만이었으므로 drop을 하지 않는다
        Assertions.assertArrayEquals(newStreamAPI.dropWhile().toArray(), List.of(1,2,3,4,5,3,2,1).toArray());
    }
    @Test
    public void testReverseSortedDropWhile(){
        // 3이상인 수가 있는 동안만 drop을 하는데, 리버스 소트시 5,4,3,3,2,2,1,1이 되므로 2,2,1,1만 남는다
        Assertions.assertArrayEquals(newStreamAPI.reverseSortedDropWhile().toArray(), List.of(2,2,1,1).toArray());
    }
    @Test
    public void testTakeWhile(){
        // 3이상인 수가 있는 동안만 take를 하는데, 2번째 숫자부터 3 미만이므로 첫 숫자만 take 된다
        Assertions.assertArrayEquals(newStreamAPI.takeWhile().toArray(), List.of(5).toArray() );
    }
}