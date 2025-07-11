package generalize;


import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Function;

public class MapPublisher<T, R> implements Publisher<R> {
    private final Publisher<T> other;
    private final Function<T, R> mapper;

    public MapPublisher(Publisher<T> other, Function<T, R> mapper) {
        this.other = other;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Subscriber<? super R> s) {
        other.subscribe(new Subscriber<T>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                s.onSubscribe(subscription);
            }

            @Override
            public void onNext(T item) {
                s.onNext(mapper.apply(item));
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
