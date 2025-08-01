import flow.async.AsyncPublisher;
import flow.async.AsyncSubscriber;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow;

public class AsyncImplementationTest {

    // 서로 다른 스레드에서 수행되며, publisher와 subscriber의 처리 속도가 다를 경우를 시뮬레이션
    @Test
    public void asyncPubSubTest() {
        Flow.Publisher<Integer> publisher = new AsyncPublisher();
        Flow.Subscriber subscriber = new AsyncSubscriber();
        publisher.subscribe(subscriber);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
