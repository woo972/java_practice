package abstract_practice;

public class Checker extends BoardGame{

    private final String title = "checker";
    private final int price = 2000;

    @Override
    protected String printGameTitle() {
        return this.title;
    }

    // overriding하지 않아서, default 메서드가 호출된다
    // printGameTitle을 overriding 했기 때문에 super.play()에서 this.printGameTitle을 호출할 것이다
//    @Override
//    public String play(){
//      ...
//    }

    // Checker로 캐스팅 된 경우에만 호출할 수 있다
    public int getPrice(){
        return this.price;
    }
}
