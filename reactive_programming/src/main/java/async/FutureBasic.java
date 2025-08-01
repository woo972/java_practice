package async;

import java.util.concurrent.*;

// 비동기 호출의 가장 기본적인 방법
// but get() 호출 지점에서 blocking
public class FutureBasic {
    public void test() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = asyncMethod(executorService);
        executorService.shutdown();
        System.out.println("executor service shutdown");
        System.out.println(future.isDone());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of main");
    }

    private Future<Integer> asyncMethod(ExecutorService executorService) {
        return executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });
    }
}
