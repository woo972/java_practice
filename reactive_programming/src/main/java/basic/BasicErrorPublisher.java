package basic;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;
import java.util.stream.Stream;

public class BasicErrorPublisher implements Publisher<Integer> {
    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                try{
                    throw new Exception("error");
                }catch (Exception e){
                    s.onError(e);
                }
            }

            @Override
            public void cancel() {
                System.out.println("cancel");
            }
        });

    }
}
