package flow.generalize;


import java.util.Iterator;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.stream.Stream;

public class RootPublisher<T> implements Publisher<T> {
    private Iterator<T> source;

    public RootPublisher(Iterator<T> source) {
        this.source = source;
    }

    @Override
    public void subscribe(Subscriber<? super T> s) {
        s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                source.forEachRemaining(s::onNext);
                s.onComplete();
            }

            @Override
            public void cancel() {
                System.out.println("cancel");
            }
        });
    }
}
