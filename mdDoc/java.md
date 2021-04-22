# 注解

https://www.jianshu.com/p/9471d6bcf4cf

https://www.jianshu.com/p/a7bedc771204

```
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    String prop1() default "val1";
    int prop2() default 1;
}
```

@Target指定这个注解的作用范围（一般就是作用在类或者方法上）

@Retention指定注解的生命周期，一般就用`RetentionPolicy.RUNTIME`

# {{}}初始化

双大括号初始化，匿名内部类初始化法