# 常用命令

参考：

https://www.cnblogs.com/wkrbky/p/6352188.html

https://blog.csdn.net/fullstack/article/details/28269471

> mvn archetype:generate

用于生成 maven 项目的骨架

> mvn compile

编译源代码

> mvn test-compile

编译测试代码

> mvn test

运行测试代码

> mvn package

打包项目 一般打包成jar包/war包

> mvn clean

清除产生的项目文件

# 参数-D -P

-D 表示设置 Properties属性

-D设置的属性可以在pom.xml中使用

```
mvn -DpropA=valueA -DpropB=valueB -DpropC=valueC clean package
```

若pom.xml中以定义相同名称的Properties，将会被上述设置的值覆盖

-P 代表 Profiles 配置文件的属性

-P用于指定Profile，比如pom.xml中定义了多个Profile，使用-P可以指定特定的Profile

```
mvn test -Ptest
```

以上命令表示即是 使用id为test的Profile环境