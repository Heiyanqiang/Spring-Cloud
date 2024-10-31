package com.itheima.mp.service.impl;
/*
 *  @author heiyanqiang
 *  @date 2024-10-31
 * */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
    @Override
    public void deductBalance(Long id, Integer money) {
        User user = getById(id);

        if (user == null || user.getStatus() == 2){
            throw new RuntimeException("用户状态异常");
        }

        if (user.getBalance() < money){
            throw new RuntimeException("用户余额不足");
        }

        baseMapper.deductMoneyById(id,money);
    }

}
