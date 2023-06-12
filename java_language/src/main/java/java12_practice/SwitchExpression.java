package java12_practice;

public class SwitchExpression {

    enum DAY{
        MON, TUE, WED, THU, FRI, SAT, SUN
    }
    public int arrowExpression() {
        DAY day = DAY.SAT;
        int order = switch (day) {
            case MON, TUE -> 1;
            case WED, THU -> 2;
            case FRI, SAT -> 3;
            default -> 4;
        };
        return order;
    }
}
