package interface_practice;

/* interface: 추상화, 다형성, 다중 상속을 위해 사용한다
* 참고: https://www.baeldung.com/java-interfaces
* */


public interface Animal {

    // Constant variable: 상속/구현하지 않고 해당 interface내에서 사용한다.
    String name = "animal";

    // abstract method: 반드시 구현해야한다
    String cry();

    // default method: 반드시 구현하지 않아도 된다.
    // interface에 신규 메서드를 추가할 경우, 기존 코드에 모두 구현을 해주어야 했다.
    // default method에서 기본 구현을 제공하기 때문에 기존 코드를 수정하지 않을 수 있다.
    default String walk(){
        return name + " is walking";
    }

    // static method: 상속/구현해서 사용하지 않고 interface에서 단독사용한다
    static boolean hasDefaultName(String input){
        return name.equals(input);
    }
}

