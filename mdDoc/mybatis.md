# 批量删除

```java
void insertBatch(List<User> users);
```

```xml
<insert id="insertBatch" parameterType="list">
    insert into user(user_name,user_psw) values
    <foreach collection="list" item="user" index="index" separator=",">
        (#{user.userName,jdbcType=VARCHAR},#{user.userPsw,jdbcType=VARCHAR})
    </foreach>
</insert>
```

