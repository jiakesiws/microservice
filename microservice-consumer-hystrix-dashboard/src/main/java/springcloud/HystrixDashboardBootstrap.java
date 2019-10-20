package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 404NotFoundx
 * @date 2019/10/20 15:16
 * @version 1.0.0
 * @since 1.8
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardBootstrap.class,args);
    }

}



