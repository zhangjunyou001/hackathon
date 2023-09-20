package com.atguigu.serviceedu.controller;


import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.entity.subject.OneSubject;
import com.atguigu.serviceedu.service.EduSubjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(description="课程分类管理")
@RestController
@RequestMapping("/eduService/subject")
//@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    /**
     * 通过上传excel文件，实现 添加课程分类（一级、二级分类）
     * @param file
     * @return
     */
     @PostMapping("addSubject")
     public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
     }

    /**
     * 获取指定格式的数据
     * 1.针对这种格式创建对应的实体类（一级分类实体类，二级分类实体类）
     * 2.在两个实体类之间表示关系（一个一级分类有多个二级分类）
     */

    /**
     * 获取所有的课程分类 信息（树形）
     * @return
     */
    @GetMapping("getAllSubject")
     public R getAllSubject(){
        List<OneSubject> list=eduSubjectService.getAllOneTwoSubject();
         return R.ok().data("list",list);
     }



}

