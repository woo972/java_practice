package flow.chaining;


import java.util.concurrent.Flow.*;

public class CancelPublisher implements Publisher<Integer> {
    private Publisher<Integer> other;

    public CancelPublisher(Publisher<Integer> other) {
        this.other = other;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        other.subscribe(new Subscriber<Integer>() {
            int counter = 0;
            Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                s.onSubscribe(this.subscription);
            }

            @Override
            public void onNext(Integer item) {
                counter++;
                if(counter >= 5) {
                    this.subscription.cancel();
                    return;
                }
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
