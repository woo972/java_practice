import basic.BasicPublisher;
import basic.BasicSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class Main {
    public static void main(String[] args) {
        Subscriber<Integer> subscriber = new BasicSubscriber();
        Publisher<Integer> publisher = new BasicPublisher();
        publisher.subscribe(subscriber);
    }
}