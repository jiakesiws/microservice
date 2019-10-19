package springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import springcloud.vo.Dept;

import java.util.List;

/**
 * 服务降级，当服务器已经down掉之后会有通知信息。
 * @author 404NotFoundx
 * @date 2019/10/19 23:24
 * @version 1.0.0
 * @since 1.8
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("ID:" + id + ",没有对应的信息，Consumer客户端提供降级信息，此刻服务Provider已关闭")
                        .setDb_source("No database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
