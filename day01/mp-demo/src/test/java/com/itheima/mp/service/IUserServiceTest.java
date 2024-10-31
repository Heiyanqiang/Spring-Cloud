package com.itheima.mp.service;

import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 *  @author heiyanqiang
 *  @date 2024-10-31
 * */

@SpringBootTest
class IUserServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    void testSaveUser(){
        //要更新的数据
        User user = new User();
        user.setId(9L);
        user.setUsername("daqiang");
        user.setPassword("333333");
        user.setPhone("18688990011");
        user.setBalance(200000000);
        user.setInfo("{\"age\": 24, \"intro\": \"大大\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        iUserService.save(user);
    }

    @Test
    void testGetAll(){
        List<User> list = iUserService.list();
        System.out.println(list);
    }
}
