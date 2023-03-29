package com.linde.design;

import com.linde.domain.User;
import com.linde.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void userSave() {
        User user = new User();
        user.setUsername("wang");
        user.setPassword("123456");
        user.setRole("hr");
        userMapper.insert(user);
    }

}
