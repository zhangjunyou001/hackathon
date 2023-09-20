package com.atguigu.eduorder.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduorder.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/eduorder/paylog")
//@CrossOrigin
public class PayLogController {

    @Autowired
    private PayLogService payLogService;

    /**
     * 生成微信支付二维码的接口
     * @param orderNo 订单号
     * @return
     */
    @GetMapping("createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo){
        Map map=payLogService.createNative(orderNo);
        System.out.println("****返回二维码map集合:"+map);
        return R.ok().data(map);
    }

    /**
     * //查询订单支付状态
     * @param orderNo 订单号，根据订单号查询 支付状态
     * @return
     */
    @GetMapping("queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable String orderNo) {

        System.out.println("#####查询订单状态");

        //真是的业务场景
//        Map<String,String> map = payLogService.queryPayStatus(orderNo);

        //为了省钱模拟出的业务场景(5秒后自动支付成功)
        Map<String,String> map = payLogService.queryPayStatusSimulation(orderNo);

        System.out.println("*****查询订单状态map集合:"+map);
        if(map == null) {
            return R.error().message("支付出错了");
        }

        //如果返回map里面不为空，通过map获取订单状态
        if(map.get("trade_state").equals("SUCCESS")) {//支付成功

            System.out.println("#####支付成功");

            //添加记录到支付表，更新订单表订单状态
            payLogService.updateOrdersStatus(map);
            return R.ok().message("支付成功");
        }
        return R.ok().code(25000).message("支付中");

    }
}

