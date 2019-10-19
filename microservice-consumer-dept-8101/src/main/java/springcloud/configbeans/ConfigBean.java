package springcloud.configbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 1:23
 * @version 1.0.0
 * @since 1.8
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 更改负载均衡轮训机制
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

}
