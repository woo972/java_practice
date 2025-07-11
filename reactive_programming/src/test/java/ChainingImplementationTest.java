import chaining.LogSubscriber;
import chaining.MapPublisher;
import chaining.RootPublisher;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow.*;

public class ChainingImplementationTest {

    // 0 ~ 90, complete 출력
    @Test
    public void test_map_case() {
        Publisher<Integer> rootPublisher = new RootPublisher();
        Publisher<Integer> mapPublisher = new MapPublisher(rootPublisher);
        Subscriber<Integer> subscriber = new LogSubscriber();
        mapPublisher.subscribe(subscriber);
    }
}
