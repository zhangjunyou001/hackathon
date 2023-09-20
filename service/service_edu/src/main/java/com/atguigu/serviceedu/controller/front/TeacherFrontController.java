package com.atguigu.serviceedu.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduCourseService;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "前台讲师")
//@CrossOrigin
@RestController
@RequestMapping("/eduService/teacherfront")
public class TeacherFrontController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 分页查询前台讲师
     * @param page
     * @param limit
     * @return
     */
    @PostMapping("getTeacherFrontList/{page}/{limit}")
    public R getTeacherFrontList(@PathVariable long page,@PathVariable long limit){
        Page<EduTeacher> pageTeacher=new Page<>(page,limit);
        Map<String,Object> map=eduTeacherService.getTeacherFrontList(pageTeacher);
        return R.ok().data(map);
    }

    /**
     * 根据讲师ID查询讲师的基本信息,课程的基本信息
     */
    @GetMapping("getTeacherFrontInfo/{teacherid}")
    public R getTeacherFrontInfo(@PathVariable String teacherid){
        //1.根据讲师ID查询讲师的基本信息
        EduTeacher eduTeacher=eduTeacherService.getById(teacherid);

        //2.根据课程ID查询课程的基本信息
        QueryWrapper<EduCourse> wrapper=new QueryWrapper<>();
        wrapper.eq("teacher_id",teacherid);
        List<EduCourse> eduCourseList = eduCourseService.list(wrapper);

        return R.ok().data("teacher",eduTeacher).data("courseList",eduCourseList);
    }

}
