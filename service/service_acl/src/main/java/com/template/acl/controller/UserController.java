package com.template.acl.controller;


import com.template.acl.entity.User;
import com.template.acl.service.UserService;
import com.template.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-10-16
 */
@RestController
@RequestMapping("/acl/user")
public class UserController {

    @Autowired
    UserService userService ;

    //1 查询讲师表所有数据
    //rest风格
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public List<User> findAllTeacher() {
        //调用service的方法实现查询所有的操作
         return userService.list(null);
    }

    //添加讲师接口的方法
    @PostMapping("addUser")
    public R addTeacher(@RequestBody User user) {
        boolean save = userService.save(user);
        if(save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}

