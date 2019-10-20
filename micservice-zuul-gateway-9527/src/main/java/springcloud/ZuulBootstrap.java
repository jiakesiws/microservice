package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 404NotFoundx
 * @date 2019/10/20 16:21
 * @version 1.0.0
 * @since 1.8
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ZuulBootstrap.class, args);
    }

}
