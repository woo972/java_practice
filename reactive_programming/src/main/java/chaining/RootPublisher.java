package chaining;


import java.util.Iterator;
import java.util.concurrent.Flow.*;
import java.util.stream.Stream;

public class RootPublisher implements Publisher<Integer> {
    private Iterator<Integer> iterator = Stream
            .iterate(0, i -> i + 1)
            .limit(10)
            .iterator();

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        s.onSubscribe(new Subscription() {
            boolean canceled = false;

            @Override
            public void request(long n) {
                iterator.forEachRemaining(x -> {
                    if (canceled) {
                        return;
                    }
                    s.onNext(x);
                });
                s.onComplete();
            }

            @Override
            public void cancel() {
                canceled = true;
                System.out.println("cancel");
            }
        });
    }
}
