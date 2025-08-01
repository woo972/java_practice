package async;

// 비동기 호출 시 Future object + callback을 넘기는 방법

import java.util.concurrent.*;

public class CallbackFutureTaskBasic {
    public void test() {

        CallbackFutureTask futureTask = new CallbackFutureTask(() -> {
            Thread.sleep(1000);
            return 10;
        }, (obj) -> System.out.println("onCompletion:"+obj.toString()), () -> System.out.println("onException"));

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(futureTask);
        executorService.shutdown();
        System.out.println("executor service shutdown");
        System.out.println("End of main");

    }

    @FunctionalInterface
    interface SuccessCallback {
        void onSuccess(Object result);
    }

    @FunctionalInterface
    interface FailureCallback {
        void onFailure();
    }

    class CallbackFutureTask extends FutureTask<Integer> {
        private Callable callable;
        private SuccessCallback onSuccess;
        private FailureCallback onException;

        public CallbackFutureTask(Callable<Integer> callable, SuccessCallback onSuccess, FailureCallback onException) {
            super(callable);
            this.callable = callable;
            this.onSuccess = onSuccess;
            this.onException = onException;
        }

        @Override
        protected void done() {
            try {
                onSuccess.onSuccess(callable.call());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                onException.onFailure();
            }
        }
    }
}
