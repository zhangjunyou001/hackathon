package com.atguigu.serviceedu.controller;


import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.vo.CourseInfoVo;
import com.atguigu.serviceedu.entity.vo.CoursePublishVo;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.serviceedu.service.EduCourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description="课程管理")
@RestController
@RequestMapping("/eduService/course")
//@CrossOrigin //跨域
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 课程列表基本实现
     * @return
     */
    @GetMapping("getCourseList")
    public R getCourseList(){
        List<EduCourse> list = eduCourseService.list(null);
        return R.ok().data("list",list);
    }

    //TODO:课程列表，条件查询带分页


    /**
     * 删除课程，同时删除课程下的阿里云视频
     * @param courseId
     * @return
     */
    @DeleteMapping("deleteCourseById/{courseId}")
    public R deleteCourseById(@PathVariable String courseId){
        R r = eduCourseService.deleteCourse(courseId);
        return R.ok();
    }




    /**
     * 添加课程信息，涉及 edu_courser 和 edu_course_description
     * @param courseInfoVo
     * @return
     */
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String id=eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",id);
    }


    /**
     * 根据课程ID查询课程信息
     * @return
     */
    @GetMapping("getCourseInfoById/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfoVo=eduCourseService.getCourseInfoById(courseId);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }

    /**
     * 更新课程信息
     * @return
     */
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    /**
     * 根据课程ID查询课程确认信息
     * @return
     */
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id){
        CoursePublishVo coursePublishVo=eduCourseService.publishCouseInfo(id);
        return R.ok().data("publishcourse",coursePublishVo);
    }


    /**
     * 最终发布课程，只需要修改课程的状态
     * Normal 已发布，Draft 未发布
     * @return
     */
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        EduCourse eduCourse=new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }






}

