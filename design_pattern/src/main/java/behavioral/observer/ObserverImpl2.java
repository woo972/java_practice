package behavioral.observer;

class ObserverImpl2 implements Observer {

    @Override
    public void update(String state) {
        System.out.println("observer 2 : " + state);
    }

}