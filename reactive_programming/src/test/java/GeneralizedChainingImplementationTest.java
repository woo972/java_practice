import flow.generalize.LogSubscriber;
import flow.generalize.MapPublisher;
import flow.generalize.RootPublisher;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.stream.Stream;

public class GeneralizedChainingImplementationTest {

    // 1 ... 1, complete 출력
    @Test
    public void test_map_case() {
        Iterator<String> iterator = Stream
                .iterate("a", String::toUpperCase)
                .limit(10)
                .iterator();
        Publisher<String> rootPublisher = new RootPublisher<>(iterator);
        Publisher<Integer> mapPublisher = new MapPublisher<>(rootPublisher, String::length);
        Subscriber<Integer> subscriber = new LogSubscriber<>();
        mapPublisher.subscribe(subscriber);
    }
}
