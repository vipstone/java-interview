package com.interview;

import com.interview.mapper.UserMapper;
import com.interview.model.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        userMapper.insert(new UserEntity("laowang", "123456", "老王"));
        Assert.assertEquals(1, userMapper.getAll().size());
    }

}
