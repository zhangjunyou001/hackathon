package com.atguigu.oss.controller;

import com.atguigu.commonutils.R;
import com.atguigu.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(description="阿里云文件管理")
//@CrossOrigin //跨域
@RestController
@RequestMapping("/eduOSS/uploadFile")
public class FileController {

	@Autowired
	private FileService fileService;

	/**
	 * 文件上传
	 *
	 * @param file
	 */
	@ApiOperation(value = "文件上传")
	@PostMapping("upload")
	public R upload(@RequestParam("file") MultipartFile file) {

		String uploadUrl = fileService.upload(file);
		//返回r对象
		return R.ok().message("文件上传成功").data("url", uploadUrl);

	}
}
