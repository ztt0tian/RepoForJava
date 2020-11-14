package com.example.boot20201114.mapper;

import com.example.boot20201114.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testUserInsert() {
        User user = new User();
        user.setUserName("u1");
        user.setUserPsw("psw1");
        userMapper.insert(user);
    }
}