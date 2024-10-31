package com.itheima.mp.controller;

/*
 *  @author heiyanqiang
 *  @date 2024-10-31
 * */

import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户管理接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

    private final IUserService userService;

    @PostMapping
    @ApiOperation("新增用户")
    public void saveUser(@RequestBody UserFormDTO userFormDTO){
        //1、转换dto为po
        User user = BeanUtil.copyProperties(userFormDTO, User.class);
        //2、新增
        userService.save(user);
    }

    @ApiOperation("根据id查询用户接口")
    @GetMapping("/{id}")
    public UserVO queryUserByIds(@ApiParam("用户id") @PathVariable("id") Long id){
        User user = userService.getById(id);
        return BeanUtil.copyProperties(user,UserVO.class);
    }

    @GetMapping()
    @ApiOperation("根据id集合查询用户")
    public List<UserVO> queryUserByIds (@RequestParam("ids") List<Long> ids){
        //查询用户
        List<User> users = userService.listByIds(ids);
        List<UserVO> userVO = BeanUtil.copyToList(users, UserVO.class);
        return userVO;
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("/{id}")
    public void removeUserById(@PathVariable("id") Long userId){
        userService.removeById(userId);
    }

    @PutMapping("{id}/deduction/{money}")
    @ApiOperation("扣减用户余额")
    public void deductBalance(@PathVariable("id") Long id,@PathVariable("money") Integer money){
        userService.deductBalance(id,money);
    }
}
