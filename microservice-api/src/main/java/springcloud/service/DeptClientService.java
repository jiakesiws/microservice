package springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springcloud.vo.Dept;

import java.util.List;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 21:35
 * @version 1.0.0
 * @since 1.8
 */
@FeignClient(value = "MICROSERVICE-DEPT")
@RequestMapping("/dept")
public interface DeptClientService {

    @RequestMapping(value = "/add")
    boolean add(Dept dept);

    @RequestMapping(value = "/get/{id}")
    Dept get(@PathVariable("id") Long id);

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/list")
    List<Dept> list();

}
