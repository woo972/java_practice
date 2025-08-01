package flow.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.*;

public class AsyncSubscriber implements Subscriber<Integer> {
    ExecutorService executorService = Executors.newSingleThreadExecutor(
            runnable -> {
                Thread thread = new Thread(runnable);
                thread.setName("AsyncSubscriber");
                return thread;
            }
    );

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Integer integer) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " : " + integer));

    }

    @Override
    public void onError(Throwable t) {
        System.out.println(t);
        executorService.shutdown();
    }

    @Override
    public void onComplete() {
        System.out.println("complete");
        executorService.shutdown();
    }
}
