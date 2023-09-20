package com.atguigu.msm.service;

import java.util.Map;

public interface MsmService {
    public boolean send(Map<String, Object> param, String phone);
}
