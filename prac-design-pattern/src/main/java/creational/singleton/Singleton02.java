package creational.singleton;

class Singleton02 {
    private static Singleton02 INSTANCE;

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }
}
