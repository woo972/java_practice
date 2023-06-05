package abstract_practice;

/* 특정 구현방법을 뒤로 미루고 싶을 떄 사용한다.
* 인터페이스에 비해 상속에 대한 계층구조를 명확히 표현할 수 있고,
* 접근제한자로 protected가 가능하기 때문에 더 명확하게 컨트롤할 수 있다.
* 참고: https://www.baeldung.com/java-abstract-class
* */
public abstract class BoardGame {

    protected String title = "board game";

    // abstract method: 추후 구현해야하는 부분
    protected abstract String printGameTitle();

    // concrete method: 이미 구현된 부분 (오버라이딩도 가능하다)
    protected String play(){
        return "play "+ printGameTitle();
    }
}
