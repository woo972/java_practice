package async;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import java.util.concurrent.Flow.*;

public class AsyncPublisher implements Publisher<Integer> {
    ExecutorService executorService = Executors.newSingleThreadExecutor(
            runnable -> {
                Thread thread = new Thread(runnable);
                thread.setName("AsyncPublisher");
                return thread;
            }
    );

    Iterator<Integer> iterator = Stream
            .iterate(0, i -> i + 1)
            .limit(10)
            .iterator();

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                long max = n;
                while(max > 0 && iterator.hasNext()) {
                    max--;
                    var x = iterator.next();
                    System.out.println(Thread.currentThread().getName()+" : "+x);
                    executorService.execute(() -> s.onNext(x));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                executorService.execute(s::onComplete);
                executorService.shutdown();
            }

            @Override
            public void cancel() {
                System.out.println("cancel");
            }
        });

    }
}
