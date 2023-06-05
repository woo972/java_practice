package abstract_practice;

public class Chess extends BoardGame{

    private final String title = "chess";

    @Override
    public String printGameTitle() {
        return super.title + ":" + this.title;
    }

    // 이미 구현된 메서드도 오버라이딩할 수 있다
    @Override
    public String play(){
        return "let's play "+printGameTitle();
    }
}
