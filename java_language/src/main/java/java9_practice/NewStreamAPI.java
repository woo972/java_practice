package java9_practice;

import java.util.List;
import java.util.stream.Stream;

public class NewStreamAPI {
    public List<Integer> dropWhile(){
        List<Integer> list = List.of(1,2,3,4,5,3,2,1);
        return list
                .stream()
                .dropWhile(n -> n >=3)
                .toList();
    }

    public List<Integer> reverseSortedDropWhile(){
        List<Integer> list = List.of(1,2,3,4,5,3,2,1);
        return list
                .stream()
                .sorted((a, b) -> b - a)
                .dropWhile(n -> n >=3)
                .toList();
    }

    public List<Integer> takeWhile(){
        List<Integer> list = List.of(5,1,2,3,4,5,3,2,1);
        return list
                .stream()
                .takeWhile(n -> n >=3)
                .toList();
    }
}
