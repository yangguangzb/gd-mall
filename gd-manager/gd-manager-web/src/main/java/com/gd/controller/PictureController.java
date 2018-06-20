package com.gd.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gd.common.util.JsonUtils;
import com.gd.service.PictureService;

/**
 * 上传图片处理
 * @description
 * @author zhangbiao
 * @time 2018-6-20 下午8:51:30
 */
@Controller
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) throws IOException{
		Map result=pictureService.uploadPicture(uploadFile);
		String json=JsonUtils.objectToJson(result);
		return json;
	}
}
