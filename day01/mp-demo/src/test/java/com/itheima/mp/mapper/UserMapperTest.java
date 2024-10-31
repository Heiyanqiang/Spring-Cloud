package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setId(5L);
        user.setUsername("Lucy");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(5L);
        System.out.println("user = " + user);
    }


    @Test
    void testQueryByIds() {
        List<User> users = userMapper.selectByIds(List.of(1L, 2L, 3L, 4L));
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(5L);
        user.setBalance(20000);
        userMapper.updateById(user);
    }

    @Test
    void testDeleteUser() {
        userMapper.deleteById(5L);
    }

    @Test
    void testQueryMapper(){
        //构建查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","username","info","balance");
        wrapper.like("username","o");
        wrapper.ge("balance",1000);
        //链式
//        wrapper.select("id","username","info","balance")
//                .like("username","o")
//                .ge("balance",1000);

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    void testUpdateByQueryWrapper(){
        //要更新的数据
        User user = new User();
        user.setId(5L);
        user.setUsername("qiangqiang");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200000000);
        user.setInfo("{\"age\": 24, \"intro\": \"学渣渣\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        //更新的条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("id",user.getId());
        userMapper.update(user,wrapper);
        //执行更新
    }
}
