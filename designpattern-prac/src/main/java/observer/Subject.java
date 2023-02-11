package observer;

interface Subject {

    public void addListener(Observer o);

    public void removeListener(Observer o);

    public void notifyListener();

    public void setState(String string);

    public String getState();
}