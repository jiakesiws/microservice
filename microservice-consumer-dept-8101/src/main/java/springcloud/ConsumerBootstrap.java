package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import springcloud.irule.ISelfRule;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 1:21
 * @version 1.0.0
 * @since 1.8
 */
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICE-DEPT",configuration = ISelfRule.class)
@SpringBootApplication
public class ConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class,args);
    }

}
