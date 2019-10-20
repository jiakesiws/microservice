package springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 404NotFoundx
 * @date 2019/10/20 17:20
 * @version 1.0.0
 * @since 1.8
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientBootstrap {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String serverPot;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBootstrap.class,args);
    }

    @RequestMapping("/config")
    public Object config() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", applicationName);
        map.put("eureka", eurekaServer);
        map.put("port", serverPot);
        return map;
    }

}
