package java16_practice;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Teeing {
    public int teeing(){
        List<Integer> numbers = List.of(1,2,3,4,5);
        return numbers.stream().collect(
                Collectors.teeing(
                        Collectors.summingInt(n -> n),
                        Collectors.counting(),
                        (sum, count) -> (int) (sum / count)));

    }
}
