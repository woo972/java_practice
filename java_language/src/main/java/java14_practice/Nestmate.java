package java14_practice;

public class Nestmate {
    private String str = "outer";

    public static void main(String[] args) {
        Nestmate outer = new Nestmate();
        InnerClass inner = outer.new InnerClass();
        inner.printStr();
    }
    public class InnerClass {
        private String newStr = "inner";

        public void printStr(){
            System.out.println(str);
            System.out.println(newStr);
        }

    }
}
