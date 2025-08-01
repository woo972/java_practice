package flow.chaining;


import java.util.concurrent.Flow.*;

public class LogSubscriber implements Subscriber<Integer> {
    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println(integer);
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
