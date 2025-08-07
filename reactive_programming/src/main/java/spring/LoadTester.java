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
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();

        log.info("start");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                StopWatch subStopWatch = new StopWatch();
                subStopWatch.start();
                webClient.get()
                        .uri("/callable")
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                subStopWatch.stop();
                log.info("sub end : {}", subStopWatch.getTotalTimeMillis());
            });
        }
        stopWatch.stop();
        executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        log.info("elapsed time : {}", stopWatch.getTotalTimeMillis());
    }
}
