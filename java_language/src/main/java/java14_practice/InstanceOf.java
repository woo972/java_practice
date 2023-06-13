package java14_practice;

public class InstanceOf {
    public void castWithInstanceOf(){
        Object obj = "object";

        if (obj instanceof String str) { // instanceof 다음 바로 할당이 가능하다
            System.out.println(str.toUpperCase());
        } else {
            System.out.println("not a string");
        }
    }
}
