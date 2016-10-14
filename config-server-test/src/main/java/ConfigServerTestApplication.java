import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by qinxi on 2016/10/14.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerTestApplication.class, args);
    }

}
