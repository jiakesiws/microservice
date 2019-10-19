package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 1:21
 * @version 1.0.0
 * @since 1.8
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"springcloud.service"})
public class ConsumerFeignBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignBootstrap.class, args);
    }

}
