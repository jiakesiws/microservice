package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 0:48
 * @version 1.0.0
 * @since 1.8
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ProviderBootstrap.class,args);
    }

}
