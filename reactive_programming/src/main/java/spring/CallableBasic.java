package spring;


import org.springframework.web.bind.annotation.*;
import java.util.concurrent.*;

@RestController
public class CallableBasic {

    @GetMapping("/basic")
    public String basic() {
        // http-nio-8080-exec-1
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // basic: http-nio-8080-exec-1
        return "basic: " + Thread.currentThread().getName();

    }

    // callable을 통해 요청 스레드를 block하지 않고 먼저 리턴한 후에 worker thread를 실행
    @GetMapping("/callable")
    public Callable<String> callable() {
        // http-nio-8080-exec-4
        System.out.println(Thread.currentThread().getName());
        return () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // callable: custom-async-task-1
            return "callable: " + Thread.currentThread().getName();
        };
    }
}
