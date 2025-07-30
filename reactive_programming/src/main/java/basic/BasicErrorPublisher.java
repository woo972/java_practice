package basic;

import java.util.concurrent.*;

public class BasicErrorPublisher implements Flow.Publisher<Integer> {
    @Override
    public void subscribe(Flow.Subscriber<? super Integer> s) {
        s.onSubscribe(new Flow.Subscription() {
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
