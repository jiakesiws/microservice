package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import springcloud.service.DeptService;
import springcloud.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 0:42
 * @version 1.0.0
 * @since 1.8
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Object get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("没有该数据，id为：" + id);
        }
        return dept;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Object list() {
        return deptService.list();
    }

    public Dept processHystrixGet(Long id) {
        return new Dept().setDeptno(id).setDname("ID:" + id + ",没有对应的信息 --@HystrixCommand")
                .setDb_source("No database in MySQL");
    }

}
