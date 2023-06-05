package interface_practice;

public class Dog implements Animal{

    public String name = "Dog";
    @Override
    public String cry() {
        return "bowwow";
    }
}
