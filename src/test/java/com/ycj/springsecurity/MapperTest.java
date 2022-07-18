package com.ycj.springsecurity;

import com.ycj.springsecurity.domain.User;
import com.ycj.springsecurity.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void TestBCryptPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encode = passwordEncoder.encode("1234");
//        String encode2 = passwordEncoder.encode("1234");
//        System.out.println(encode);
//        System.out.println(encode2);
        System.out.println(passwordEncoder.matches("1234", "$2a$10$p.vcHXODyFLNGdrSWbBl9utFL5qWw6xYlvwI9qMcGU9xu1akCjzWS"));
    }

    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
