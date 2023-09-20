package com.atguigu.serviceedu.client;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "service-vod", fallback = VodFileDegradeFeignClient.class)////服务发现,熔断
@Component
public interface VodClient {

	//调用的路径

	/**
	 * 根据视频ID删除阿里云里面的视频
	 * 使用 服务发现 调用 service-vod 里面的方法
	 * @PathVariable 注解一定要指定参数名称，否则出错
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/eduvod/video/removeAlyVideo/{id}")
	public R removeAlyVideo(@PathVariable("id") String id);

	/**
	 * 批量删除阿里云里面的视频
	 * @param videoIdList
	 * @return
	 */
	@DeleteMapping("/eduvod/video/delete-batch")
	public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);
}
