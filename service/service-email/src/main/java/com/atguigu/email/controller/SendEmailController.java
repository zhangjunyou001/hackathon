package com.atguigu.email.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.atguigu.commonutils.R;
import com.atguigu.email.utils.MultipartFileToFile;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Api(description = "发送邮件")
@RestController
@RequestMapping("/eduemail/email")
//@CrossOrigin
public class SendEmailController {


    /**
     * 给一个人发送邮件,简单实现【一般用于登录注册】
     * @return
     */
    @PostMapping("sendemail/{tosomeone}")
    public R sendEmail(@PathVariable String tosomeone){
        String code= UUID.randomUUID().toString().replaceAll("-","").substring(0,4);
        String emailsubject="谷粒学院账号登录";
        String emailcontent="【谷粒学院】您正在登录谷粒商城，验证码是:"+code+",五分钟有效,请及时登录。为了您的账号安全，请勿将验证码透漏给他人!";
        MailUtil.send(tosomeone, emailsubject, emailcontent, false);
        return R.ok();
    }

//    /**
//     * 给一个人发送邮件
//     * @return
//     */
//    @PostMapping("sendEmailTest/{tosomeone}")
//    public R SendEmailTest(@PathVariable String tosomeone){
//        MailAccount account = new MailAccount();
//        //服务器地址：SMTP服务器:
//        account.setHost("smtp.163.com");
//        account.setPort(25);
//        account.setAuth(true);
//        account.setFrom("G2290676567@163.com");
//        account.setUser("G2290676567@163.com");
//        //授权码
//        account.setPass("QCDFYUALSBNLYUFV");
//        //对象，要发送的邮箱集合，主题，邮件内容，默认false
//        MailUtil.send(account, CollUtil.newArrayList(tosomeone), "Java邮件测试", "邮件来自Hutool测试", false);
//        return R.ok();
//    }


    /**
     * 给某人发送邮件 并携带附件
     * @param tosomeone
     * @param file
     * @return
     */
    @PostMapping("sendemailwithfile/{tosomeone}")
    public R SendEmailWithFile(@PathVariable("tosomeone") String tosomeone ,@RequestParam("file") MultipartFile file) throws IOException {
        String emailsubject="来自谷粒学院的文件";
        String emailcontent="【谷粒学院】您有一封来自谷粒学院的邮件，请注意及时查看此邮件中携带的附件。";

        File myfile = null;
        try {
            myfile = MultipartFileToFile.multipartFileToFile(file);
            //发送邮件带有附件
            MailUtil.send(tosomeone, emailsubject, emailcontent, true,myfile);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MultipartFileToFile.deleteTempFile(myfile);//删除本地缓存文件
        }

        return R.ok();
    }


    /**
     * 批量发送邮件，一般用于管理员批量通知，需要自定义通知信息
     * @return
     */
    @PostMapping("sendemailbatch/{fromsomeone}/{info}")
    public R SendEmailBatch(@PathVariable("fromsomeone") String fromsomeone,@PathVariable("info") String info,@RequestBody ArrayList<String> arrayList){
        String subject="来自谷粒学院的通知";
        String content= String.format("来自%s的通知:%s",fromsomeone,info);
        MailUtil.send(arrayList, subject, content, false);
        return R.ok();
    }

}
