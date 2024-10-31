package com.itheima.mp.service;/*
 *  @author heiyanqiang
 *  @date 2024-10-31
 * */

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;

public interface IUserService extends IService<User> {
    void deductBalance(Long id, Integer money);
}
