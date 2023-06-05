package interface_practice.functional_interface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 참고: https://www.baeldung.com/java-8-functional-interfaces
* java8부터 람다 표현식이 가능해지면서, 일급객체(파라미터로 전달하거나 리턴값으로 받을 수 있다)로서 익명 함수를 취급할 수 있게 되었다
* */
public class FunctionalInterface {
    /* Predicate
        T 타입 인풋을 받아, boolean으로 리턴한다 */
    private final Predicate<String> hasTest = (input) -> input.contains("test");
    private final Predicate<String> hasPass = (input) -> input.contains("pass");
    private final Predicate<String> hasFail = (input) -> input.contains("fail");

    public boolean hasTestAndPassButFail(String input){
        return hasTest
                .and(hasPass)
                .and(hasFail)
                .negate()
                .test(input);
    }

    /* Supplier
        파라미터 없이 특정 값을 lazy 방식으로 생성하기 위한 함수
        외부 변수(final)를 활용해서 값을 생성해야할 때 유용하다
    * */
    private final int[] fibo = {0, 1};
    private final Supplier<Integer> supplyCreatedFibo = () -> {
        int fibo3 = fibo[0] + fibo[1];
        fibo[0] = fibo[1];
        fibo[1] = fibo3;
        return fibo3;
    };
    public void gatherCreatedFibo(){
        Stream.generate(supplyCreatedFibo); // 무한 스트림
    }

    /* Consume
    Supplier와 반대로 리턴 값이 없음*/

    /* Function
        T 타입을 파라미터로 받아 R 타입으로 리턴
        compose를 이용해서 체이닝하는 것도 가능하다
    * */

    private final Function<Integer, String> intoString = Object::toString;
    private final Function<String, String> quoteString = s -> "'" +s+"'";
    private final Function<Integer, String> quoteIntoToString = quoteString.compose(intoString);

    public String quotedNumber(int number){
        return quoteIntoToString.apply(number);
    }

    /* Operator
    *  T타입 입력을 받아 T타입을 리턴함 */
    private final UnaryOperator<Integer> addOne = i -> i+1;
    private final BinaryOperator<Integer> reduce = (a, b) -> addOne.apply(a) + addOne.apply(b);

    public int add1() {
        return Stream.of(1, 2, 3)
                .reduce(reduce)
                .get();
    }
}
