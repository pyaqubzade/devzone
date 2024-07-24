package az.pashabank.devzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DevzoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevzoneApplication.class, args);
    }

}
