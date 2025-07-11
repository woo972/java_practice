package basic;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;
import java.util.stream.Stream;

public class BasicPublisher implements Publisher<Integer> {
    Iterator<Integer> iterator = Stream
            .iterate(0, i -> i + 1)
            .limit(10)
            .iterator();

    // Publisher는 subscribe 메서드 하나만을 가지고 있다.
    // subscribe 메서드에 parameter로 Subscriber를 넘겨서 구독한다.
    // subscription은 publisher와 subscriber를 매핑하는 연결이다.
    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                long max = n;
                while(max > 0 && iterator.hasNext()) {
                    max--;
                    s.onNext(iterator.next());
                }
                s.onComplete();
            }

            @Override
            public void cancel() {
                System.out.println("cancel");
            }
        });

    }
}
