package behavioral.observer;

class ObserverImpl1 implements Observer {

    @Override
    public void update(String state) {
        System.out.println("observer 1 : " + state);
    }

}