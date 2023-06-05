package interface_practice;

public class Cat implements Animal{

    public String name = "Cat";
    @Override
    public String cry() {
        return "grrr";
    }

    // default method를 오버라이딩할 수도 있다
    @Override
    public String walk() {
        return "soft walking";
    }
}
