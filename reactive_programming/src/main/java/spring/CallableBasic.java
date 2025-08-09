package spring;


import lombok.extern.slf4j.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.*;

@RestController
@Slf4j
public class CallableBasic {
    @GetMapping("/hello")
    public Callable<String> hello() {
        log.info(Thread.currentThread().getName());
        return () -> {
            service();
            return Thread.currentThread().getName();
        };
    }

    private void service(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // callable을 통해 요청 스레드를 block하지 않고 먼저 리턴한 후에 worker thread를 실행
    /*

    Client 요청
   ↓
   [Acceptor] → 연결 수락
     ↓
    [Poller] → 요청이 읽기 가능 상태인지 확인
     ↓
    [Executor] → 실제 요청 처리 (ex: Controller 실행)
   ↓
    Tomcat Executor 스레드 → DispatcherServlet
   ↓
    Controller에서 Callable 반환
   ↓
    Tomcat 스레드 반환됨 (풀로 복귀)
   ↓
    Spring 내부 TaskExecutor가 별도 스레드로 Callable 실행
   ↓
    작업 완료 시 DispatcherServlet으로 복귀 → 응답 전송



    * */


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
