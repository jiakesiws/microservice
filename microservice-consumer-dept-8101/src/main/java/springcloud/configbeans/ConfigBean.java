package springcloud.configbeans;

import com.netflix.loadbalancer.*;
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
     *
     * RoundRobinRule               轮训算法
     * RandomRule                   随机算法
     * ZoneAvoidanceRule            默认规则，复合判断server所在区域的性能和server可用性选择服务器
     * BestAvailableRule            会先过滤多次访问故障而跳闸的服务，然后选择一个并发量小的服务
     * RetryRule                    先按照RoundRobinRule策略获取服务，如果失败在指定时间内会重试获取可用服务
     * AvailabilityFilteringRule    会先过滤多次访问故障而跳闸的服务
     * WeightedResponseTimeRule     根据平均响应时间计算服务的权重，权重越大选中几率越高
     *
     * @return 规则
     */
    @Bean
    public IRule iRule(){
        return new ZoneAvoidanceRule();
    }

}
