package com.atguigu.msm.controller;

import com.atguigu.commonutils.R;
import com.atguigu.msm.service.MsmService;
import com.atguigu.msm.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequestMapping("/edumsm/msm")
@RestController
//@CrossOrigin
public class MsmController {
    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 发送短信的方法【申请不来短信服务，发不了短信，进行功能阉割】
     * @param phone
     * @return
     */
    @GetMapping("send/{phone}")
    public R sendMsm(@PathVariable String phone) {
        //1.从redis获取验证码，如果获取到直接返回【5分钟内有验证码不重复发送】
        String code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)) {
            System.out.println("验证码已存在，是："+code);
            return R.ok();
        }
        //2.如果redis获取 不到，进行阿里云发送
        //生成随机值，传递阿里云进行发送
        String codemsg = RandomUtil.getFourBitRandom();
        Map<String, Object> param = new HashMap<>();
        param.put("code", codemsg);
        System.out.println("新生成的验证码是："+codemsg);
        //假设发送成功，把发送成功验证码放到redis里面
        redisTemplate.opsForValue().set(phone, codemsg, 5, TimeUnit.MINUTES);//设置有效时间5min
        return R.ok();
    }
//
//    /**
//     * 发送短信的方法【完整的方法】
//     * @param phone
//     * @return
//     */
//    @GetMapping("send/{phone}")
//    public R sendMsm(@PathVariable String phone) {
//        //1 从redis获取验证码，如果获取到直接返回
//        String code = redisTemplate.opsForValue().get(phone);
//        if(!StringUtils.isEmpty(code)) {
//            return R.ok();
//        }
//        //2 如果redis获取 不到，进行阿里云发送
//        //生成随机值，传递阿里云进行发送
//        code = RandomUtil.getFourBitRandom();
//        Map<String,Object> param = new HashMap<>();
//        param.put("code",code);
//        //调用service发送短信的方法
//        boolean isSend = msmService.send(param,phone);
//        if(isSend) {
//            //发送成功，把发送成功验证码放到redis里面
//            //设置有效时间
//            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
//            return R.ok();
//        } else {
//            return R.error().message("短信发送失败");
//        }
//    }
}
