package java10_practice;

import java.util.List;
import java.util.Optional;

public class OptionalClass {

    public List<String> optional(){
        var optional = Optional.of("String");  // 타입추론이 가능한 var 키워드 (로컬변수만 가능)
        return optional.stream() // java10부터는 optional에서 stream을 사용할 수 있다
                .filter(s -> s.equals("String"))
                .toList();
    }
}
