package java11_practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewHttpClientTest {
    NewHttpClient sut = new NewHttpClient();

    @Test
    public void testHttpClient(){
        // 샘플데이터에 "data"라는 문자열이 있음
        assertTrue(sut.http().contains("data"));
    }
}