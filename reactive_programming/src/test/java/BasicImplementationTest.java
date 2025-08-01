import flow.basic.BasicErrorPublisher;
import flow.basic.BasicPublisher;
import flow.basic.BasicSubscriber;
import org.junit.jupiter.api.Test;
import java.util.concurrent.Flow.*;

public class BasicImplementationTest {

    // 0 ~ 9 , complete 출력
    @Test
    public void test_on_complete_case() {
        Publisher<Integer> publisher = new BasicPublisher();
        Subscriber<Integer> subscriber = new BasicSubscriber();
        publisher.subscribe(subscriber);

    }

    // error message 출력
    @Test
    public void test_on_error_case() {
        Publisher<Integer> publisher = new BasicErrorPublisher();
        Subscriber<Integer> subscriber = new BasicSubscriber();
        publisher.subscribe(subscriber);

    }
}
