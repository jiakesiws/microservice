package springcloud.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * 序列化的原因是因为分布式需要将网络传输进行持久化操作。
 * @author 404NotFoundx
 * @date 2019/10/18 22:17
 * @version 1.0.0
 * @since 1.8
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@SuppressWarnings("serial")
public class Dept implements Serializable {

    private Long deptno; // 主键
    private String dname; // 部门名称
    private String db_source; // 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库

}
