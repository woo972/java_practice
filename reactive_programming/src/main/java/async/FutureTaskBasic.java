package async;

// 비동기 호출 시 Future object를 넘기는 방법

import java.util.concurrent.*;

public class FutureTaskBasic {
    public void test() {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return 10;
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(futureTask);
        executorService.shutdown();
        System.out.println("executor service shutdown");
        System.out.println("End of main");

        try {
            System.out.println(futureTask.isDone());
            System.out.println(futureTask.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
