package com.atguigu.serviceedu.controller;

import com.atguigu.commonutils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(description="登录管理")
@RestController
@RequestMapping("/eduService/user")
//@CrossOrigin //跨域
public class EduLoginController {

    /**
     * 模拟登录
     * @return
     */
    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    /**
     * 模拟获取用户信息
     * @return
     */
    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").
                data("name","admin").
                data("avatar","https://gitee.com/geng_kun_yuan/myimg/raw/master/img/20210918164842.png");
    }
}
