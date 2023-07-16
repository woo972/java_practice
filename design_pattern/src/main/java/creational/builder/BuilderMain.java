package creational.builder;

class BuilderMain {
    public static void main(String[] args) {
        User01 u11 = new User01("john");
        User01 u12 = new User01("john", "010-0000-0000", "teacher");

        User02 u21 = new User02.Builder("john").build();
        User02 u22 = new User02.Builder("john").tel("010-0000-0000").job("teacher").build();
    }
}