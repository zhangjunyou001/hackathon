package com.atguigu.eduorder.client;

import com.atguigu.commonutils.ordervo.CourseWebVoOrder;
import com.atguigu.commonutils.ordervo.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("service-edu")
public interface EduClient {

 /**
  * 根据课程ID查询课程信息，目的在于 service-order 中的远程调用
  */
 @PostMapping("/eduService/coursefront/getCourseInfoOrder/{id}")
 public CourseWebVoOrder getCourseInfoOrder(@PathVariable("id") String id);



 }
