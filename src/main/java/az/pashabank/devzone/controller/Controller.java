package az.pashabank.devzone.controller;

import az.pashabank.devzone.client.Feign;
import az.pashabank.devzone.client.RestClient;
import az.pashabank.devzone.client.RestTemplateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class Controller {

    private final RestTemplateClient restTemplateClient;
    private final RestClient restClient;
    private final Feign feignClient;

    public enum Type {
        CREATE, READ, UPDATE, MODIFY, DELETE
    }

    @GetMapping("/rest-template/{type}")
    public String invokeRestTemplate(@PathVariable Type type) {
        return switch (type) {
            case READ -> restTemplateClient.get();
            case CREATE -> restTemplateClient.post();
            case UPDATE -> restTemplateClient.put();
            case MODIFY -> restTemplateClient.patch();
            case DELETE -> restTemplateClient.delete();
        };
    }

    @GetMapping("/rest-client/{type}")
    public String invokeRestClient(@PathVariable Type type) {
        return switch (type) {
            case READ -> restClient.get();
            case CREATE -> restClient.post();
            case UPDATE -> restClient.put();
            case MODIFY -> restClient.patch();
            case DELETE -> restClient.delete();
        };
    }

    @GetMapping("/feign/{type}")
    public String invokeFeignClient(@PathVariable Type type) {
        return switch (type) {
            case READ -> feignClient.getUser().name();
            case CREATE -> feignClient.createUser().name();
            case UPDATE -> feignClient.updateUser().name();
            case MODIFY -> feignClient.modifyUser().name();
            case DELETE -> feignClient.deleteUser().name();
        };
    }
}
