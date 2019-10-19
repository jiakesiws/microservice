package springcloud.controller;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Object list() {
        return deptService.list();
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**************" + list);
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICE-DEPT");
        for (ServiceInstance element : serviceInstances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort()
                    + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }

}
