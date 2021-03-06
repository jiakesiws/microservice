package springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import springcloud.vo.Dept;

import java.util.List;

/**
 * @author 404NotFoundx
 * @date 2019/10/18 23:54
 * @version 1.0.0
 * @since 1.8
 */
@Mapper
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();

}
