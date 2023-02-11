package observer;

class ObserverMain {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Observer observer1 = new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();

        subject.addListener(observer1);
        subject.addListener(observer2);
        subject.setState("oserver1, 2 등록 후 새로운 데이터1");

        subject.removeListener(observer1);
        subject.setState("observer1 삭제 후 새로운 데이터2");
    }
}