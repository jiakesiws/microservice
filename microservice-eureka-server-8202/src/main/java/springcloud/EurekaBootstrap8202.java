package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 14:53
 * @version 1.0.0
 * @since 1.8
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaBootstrap8202 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaBootstrap8202.class, args);
    }

}
