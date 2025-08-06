package spring;

import lombok.extern.slf4j.*;
import org.springframework.util.*;
import org.springframework.web.reactive.function.client.*;

import java.util.concurrent.*;

@Slf4j
public class LoadTester {
    public static void main(String[] args) throws InterruptedException {
        new LoadTester().run();
    }

    public void run() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();

        log.info("start");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                log.info("call endpoint");
                StopWatch subStopWatch = new StopWatch();
                subStopWatch.start();
                webClient.get()
                        .uri("/basic")
                        .retrieve()
                        .bodyToMono(String.class)
                        .doOnSuccess(response -> log.info("response : {}", response))
                                ;
                subStopWatch.stop();
                log.info("elapsed time : {}", subStopWatch.getTotalTimeMillis());
            });
        }
        stopWatch.stop();
        executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        log.info("ALL END. elapsed time : {}", stopWatch.getTotalTimeMillis());
    }
}
