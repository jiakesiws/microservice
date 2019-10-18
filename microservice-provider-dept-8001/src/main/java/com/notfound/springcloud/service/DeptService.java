package com.notfound.springcloud.service;

import com.notfound.springcloud.vo.Dept;

import java.util.List;

/**
 * @author 404NotFoundx
 * @date 2019/10/19 0:38
 * @version 1.0.0
 * @since 1.8
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

}
