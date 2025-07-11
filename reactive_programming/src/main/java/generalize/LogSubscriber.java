package generalize;


import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class LogSubscriber<T> implements Subscriber<T> {
    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        System.out.println(item);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println(t);
    }

    @Override
    public void onComplete() {
        System.out.println("complete");
    }
}
