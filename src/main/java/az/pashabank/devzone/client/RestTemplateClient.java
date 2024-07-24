package az.pashabank.devzone.client;

import az.pashabank.devzone.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class RestTemplateClient {

    private final RestTemplate restTemplate;

    public String get() {
        var params = new HashMap<>();
        var user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/{id}", User.class, 2L);
        return user.name();
    }

    public String post() {
        var newUser = new User(null, "Test");
        var user = restTemplate.postForObject("https://jsonplaceholder.typicode.com/users", newUser, User.class);
        return user.name();
    }

    public String put() {
        var newUser = new User(null, "Test");
        restTemplate.put("https://jsonplaceholder.typicode.com/users/1", newUser);
        return "updated";
    }

    public String patch() {
        var newUser = new User(null, "Test");
        var user = restTemplate.patchForObject("https://jsonplaceholder.typicode.com/users", newUser, User.class);
        return user.name();
    }

    public String delete() {
        restTemplate.delete("https://jsonplaceholder.typicode.com/users", 1L);
        return "deleted";
    }
}
