package com.atguigu.serviceedu.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduCourseService;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@Api(description = "首页数据")
@RestController
@RequestMapping("/eduService/indexfront")
//@CrossOrigin
public class IndexFrontController {

    @Autowired
    private EduCourseService eduCourseService;

    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询前 8条 热门课程,查询 前4条 名师
     */
    @GetMapping("index")
    public R index(){
        //查询前8条热门课程

        List<EduCourse> eduCourseList=eduCourseService.getHotCourse();
        //查询前4条名师
        List<EduTeacher> eduTeacherList=eduTeacherService.getHotTeacher();

        return R.ok().data("courseList",eduCourseList).data("teacherList",eduTeacherList);
    }



}
