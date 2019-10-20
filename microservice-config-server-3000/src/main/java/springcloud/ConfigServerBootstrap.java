package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 404NotFoundx
 * @date 2019/10/20 17:20
 * @version 1.0.0
 * @since 1.8
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerBootstrap.class,args);
    }

}
