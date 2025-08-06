package spring;


import org.springframework.web.bind.annotation.*;
import java.util.concurrent.*;

@RestController
public class CallableBasic {

    @GetMapping("/basic")
    public String basic() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "basic: " + Thread.currentThread().getName();
    }

    @GetMapping("/callable")
    public Callable<String> callable() {
        return () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "callable: " + Thread.currentThread().getName();
        };
    }
}
