package flow.basic;

import java.util.concurrent.Flow.*;

public class BasicSubscriber implements Subscriber<Integer> {
    // onSubscribe를 통해 subscription의 request를 수행한다.
    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    // onNext로 이벤트를 전달한다. 이벤트는 0부터 n개까지(즉, 무한대로) 발행한다.
    @Override
    public void onNext(Integer integer) {
        System.out.println(integer);
    }

    // onError와 onComplete는 둘 중 하나만 발생한다.
    @Override
    public void onError(Throwable t) {
        System.out.println(t);
    }

    @Override
    public void onComplete() {
        System.out.println("complete");
    }
}
