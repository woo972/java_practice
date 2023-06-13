package java14_practice;

public class HelpfulNullPointerException {
    public static void main(String[] args) {
        String str = null;
        str.length();
    /*
    Exception in thread "main" java.lang.NullPointerException:
    Cannot invoke "String.length()" because "str" is null
    at java14_practice.HelpfulNullPointerException.main(HelpfulNullPointerException.java:6)
    */
    }
}
