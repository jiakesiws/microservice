package springcloud.irule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 假设当前有个需求为每个服务要求被调用5次，那么这个负载均衡算法就需要自定义了。
 * 当前类的源码是基于 Ribbon 默认的 RandomRule 负载均衡代码修改的，代码网址在github上：
 * <url>
 *     https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java
 * </url>
 * @author 404NotFoundx
 * @date 2019/10/19 20:56
 * @version 1.0.0
 * @since 1.8
 */
public class IRandomRule extends AbstractLoadBalancerRule {

    private int total = 0;
    private int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            // int index = chooseRandomInt(serverCount);
            // server = upList.get(index);

            //
            // 修改的关键代码在这里
            //
            if(total < 5){
                server = upList.get(currentIndex);
                total++;
            }else{
                if(currentIndex == (upList.size() - 1)){
                    currentIndex = 0;
                }else{
                    currentIndex++;
                }
                server = upList.get(currentIndex);
                total = 0;
            }
            // END 自定义代码结束

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}