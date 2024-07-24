package az.pashabank.devzone.client;

import az.pashabank.devzone.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class RestClient {

    private final org.springframework.web.client.RestClient restClient;

    public RestClient() {
        this.restClient = org.springframework.web.client.RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public String get() {
        var user = restClient
                .get()
                .uri("/users/{id}", 1L)
                .retrieve()
                .body(User.class);
        return user.name();
    }

    public String post() {
        var newUser = new User(null, "Created");
        var user = restClient
                .post()
                .uri("/users")
                .body(newUser)
                .retrieve()
                .body(User.class);
        return user.name();
    }

    public String put() {
        var newUser = new User(1L, "Updated");
        var user = restClient
                .put()
                .uri("/users/{id}", 1L)
                .body(newUser)
                .retrieve()
                .body(User.class);
        return user.name();
    }

    public String patch() {
        var newUser = new User(1L, "Patched");
        var user = restClient
                .patch()
                .uri("/users/{id}", 1L)
                .body(newUser)
                .retrieve()
                .body(User.class);
        return user.name();
    }

    public String delete() {
        var user = restClient
                .delete()
                .uri("/users/{id}", 1L)
                .retrieve()
                .body(User.class);
        return user.name();
    }
}
