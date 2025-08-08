package spring;

import lombok.extern.slf4j.*;
import org.springframework.util.*;
import org.springframework.web.client.*;
import org.springframework.web.reactive.function.client.*;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

@Slf4j
public class LoadTester {
    public static void main(String[] args) throws InterruptedException {
        new LoadTester().run();
    }

    public void run() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        RestTemplate restTemplate = new RestTemplate();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                StopWatch subStopWatch = new StopWatch();
                subStopWatch.start();

                restTemplate.getForObject("http://localhost:8080/hello", String.class);

                subStopWatch.stop();
                log.info("executor count: {}, elapsed time : {}", count.getAndIncrement(), subStopWatch.getTotalTimeMillis());
            });
        }

        executorService.shutdown();
        // shutdown이 실행된 이후, 다른 모든 작업이 끝나길 block 하는 시간
        executorService.awaitTermination(100, TimeUnit.MINUTES);

        stopWatch.stop();
        log.info("elapsed time : {}", stopWatch.getTotalTimeMillis());
    }
}
