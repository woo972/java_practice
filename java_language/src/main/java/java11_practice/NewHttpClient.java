package java11_practice;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewHttpClient {

    public String http(){
        var httpClient = HttpClient.newHttpClient();

        HttpRequest request;
        HttpResponse<String> response;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://reqres.in/api/users/2"))
                    .build();

            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
