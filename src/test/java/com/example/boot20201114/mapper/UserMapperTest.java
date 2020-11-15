package com.example.boot20201114.mapper;

import cn.hutool.core.util.IdUtil;
import com.example.boot20201114.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    private final int BATCH_SIZE = 10000;
    private final int INSERT_SIZE = 10;
    @Test
    public void testUserInsert() {
        User user = new User();
        user.setUserName(IdUtil.randomUUID());
        user.setUserPsw(IdUtil.fastSimpleUUID());
        userMapper.insert(user);
    }

    @Test
    public void testInsertBatch() {
        List<User> users = new ArrayList<>(BATCH_SIZE);
        for (int i = 0; i <BATCH_SIZE ; i++) {
            User user = new User();
            user.setUserName(IdUtil.randomUUID());
            user.setUserPsw(IdUtil.fastSimpleUUID());
            users.add(user);
        }
        userMapper.insertBatch(users);
    }
}