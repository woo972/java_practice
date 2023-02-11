package creational.singleton;

class SingletonMain {
    public static void main(String[] args) {
        Singleton01 s11 = Singleton01.getInstance();
        Singleton01 s12 = Singleton01.getInstance();
        System.out.println(s11 == s12);

        Singleton02 s21 = Singleton02.getInstance();
        Singleton02 s22 = Singleton02.getInstance();
        System.out.println(s21 == s22);

        Singleton03 s31 = Singleton03.INSTANCE;
        Singleton03 s32 = Singleton03.INSTANCE;
        System.out.println(s31 == s32);

    }
}