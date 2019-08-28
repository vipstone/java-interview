package com.interview.mybatislearning;

import com.interview.mybatislearning.mapper.UserMapper;
import com.interview.mybatislearning.model.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatislearningApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        userMapper.insert(new UserEntity("laowang", "123456", "老王"));
        Assert.assertEquals(1, userMapper.getAll().size());
    }

}
