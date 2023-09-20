package com.atguigu.serviceedu.client;

import com.atguigu.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断器实现，
 * 调用方法出错之后会执行
 */
@Component
public class VodFileDegradeFeignClient implements VodClient {

    @Override
    public R removeAlyVideo(String id) {
        return R.error();
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return null;
    }
}
