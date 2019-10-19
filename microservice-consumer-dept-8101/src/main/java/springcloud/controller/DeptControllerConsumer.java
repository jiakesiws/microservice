package springcloud.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.vo.Dept;

import java.util.List;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 1:36
 * @version 1.0.0
 * @since 1.8
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptControllerConsumer {

    private static final String URL_PREFIX = "http://MICROSERVICE-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/list")
    public List<Dept> list() {
        return restTemplate.getForObject(URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/discovery")
    public Object discovery() {
        return restTemplate.getForObject(URL_PREFIX + "/dept/discovery", Object.class);
    }

}
