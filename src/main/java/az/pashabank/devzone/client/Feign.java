package az.pashabank.devzone.client;

import az.pashabank.devzone.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mock", url = "https://jsonplaceholder.typicode.com")
public interface Feign {

    @GetMapping("/users/{id}")
    User get(@PathVariable Long id);

    @PostMapping("/users")
    User post(@RequestBody User user);

    @PutMapping("/users/{id}")
    User put(@PathVariable Long id, @RequestBody User user);

    @PatchMapping("/users/{id}")
    User patch(@PathVariable Long id, @RequestBody User user);

    @DeleteMapping("/users/{id}")
    User delete(@PathVariable Long id);

    default User getUser() {
        return get(1L);
    }

    default User createUser() {
        var newUser = new User(null, "Created");
        return post(newUser);
    }

    default User updateUser() {
        var newUser = new User(null, "Updated");
        return put(1L, newUser);
    }

    default User modifyUser() {
        var newUser = new User(null, "Created");
        return patch(1L, newUser);
    }

    default User deleteUser() {
        return delete(1L);
    }
}
