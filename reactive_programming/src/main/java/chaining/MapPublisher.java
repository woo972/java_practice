package chaining;


import java.util.concurrent.Flow.*;

public class MapPublisher implements Publisher<Integer> {
    private Publisher<Integer> other;

    public MapPublisher(Publisher<Integer> other) {
        this.other = other;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        other.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                s.onSubscribe(subscription);
            }

            @Override
            public void onNext(Integer item) {
                s.onNext(item * 10);
            }

            @Override
            public void onError(Throwable throwable) {
                s.onError(throwable);
            }

            @Override
            public void onComplete() {
                s.onComplete();
            }
        });
    }
}
