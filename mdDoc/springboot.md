---
typora-root-url: pic
typora-copy-images-to: pic
---

# 集成mybatis

>  选择依赖

![image-20210422200416547](/image-20210422200416547.png)

> 基本服务配置

application.properties

```properties
# 服务启动端口
server.port=8080
# 数据库连接信息
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:mysql://localhost:3306/ztt?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# mybatis的配置
# 指定 MyBatis 主配置文件的位置
mybatis.config-location=classpath:mybatis/mybatis-config.xml
# 指定 mapper 文件的位置，对dao层函数的sql映射
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
```

> 目录结构

![image-20210422213545575](/image-20210422213545575.png)

> 关键文件代码

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- 详细参考 https://mybatis.org/mybatis-3/zh/configuration.html -->
<configuration>
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
<!--        <setting name="logImpl" value="STDOUT_LOGGING "/>-->
    </settings>
</configuration>
```

User.java

```java
public class User {
    private Integer userId;
    private String userName;
    private String userPsw;
    private String phone;
    private Date createTime;
    private Date updateTime;
    private Date lastLoginTime;
    ...
}
```

UserMapper.java

```java
public interface UserMapper {
    void insert(User user);
}
```

WithMybatisApplication.java

```java
@SpringBootApplication
@MapperScan(basePackages = {"com.ztt.with_mybatis.mapper"})
public class WithMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(WithMybatisApplication.class, args);
    }
}
```

Test类

```java
@RunWith(SpringRunner.class)
@SpringBootTest
class WithMybatisApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Test
    void testInsert() {
        userMapper.insert(new User());
    }
}
```

# 事务配置

> 不配事务的影响

某个service方法，涉及多次数据库写操作，本来要么全部成功，要么全部失败，即作为事务处理，如果不配置事务，如果中间出现异常则不会回滚异常出现前的写操作

```java
public class TxServiceImpl implements ITxService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void insertTwice() {
        // 第一次插入
        userMapper.insert(new User("U1", "psw"));
        // 模拟业务中间出行运行时异常
        System.out.println(1 / 0);
        // 第二次插入
        userMapper.insert(new User("U2", "psw"));
    }
}
```

上面的程序若未配置事务控制，则会出现这种结果：第一次数据插入成功，第二次数据没有插；会与期望有出入