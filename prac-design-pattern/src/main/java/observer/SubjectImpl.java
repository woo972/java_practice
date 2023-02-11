package observer;

import java.util.ArrayList;
import java.util.List;

class SubjectImpl implements Subject {

    private List<Observer> observerList;
    private String subjectState;

    public SubjectImpl() {
        this.observerList = new ArrayList<Observer>();
        this.subjectState = "빈 자료";
    }

    public void setState(String subjectState) {
        this.subjectState = subjectState;
        notifyListener();
    }

    public String getState() {
        return this.subjectState;
    }

    @Override
    public void addListener(Observer o) {
        if (!observerList.contains(o)) {
            observerList.add(o);
        }
        System.out.println("observer 등록");
    }

    @Override
    public void removeListener(Observer o) {
        observerList.remove(o);
        System.out.println("observer 삭제");
    }

    @Override
    public void notifyListener() {
        observerList.forEach((observer) -> observer.update(getState()));
    }

}