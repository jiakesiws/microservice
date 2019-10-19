package springcloud.irule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的负载均衡轮训算法
 * @author 404NotFoundx
 * @date 2019/10/19 20:13
 * @version 1.0.0
 * @since 1.8
 */
@Configuration
public class ISelfRule {

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
     * 如果要自定义，需要在启动类添加 @RibbonClient 注解，例如：
     * <code>
     *     code --> @RibbonClient(name = "MICROSERVICE-DEPT",configuration = ISelfRule.class)
     * </code>
     *
     * 其中的 ISelfRule 是我们自定义的算法类，值的注意的是：
     * ISelfRule 或其他自定义负载均衡算法类不能放在 @ComponentScan 注解扫描的包或子包下，否则这个轮训机制将会被所有服务共享。
     *
     * @return 规则
     */
    @Bean
    public IRule iRule() {
        return new IRandomRule();
    }

}
