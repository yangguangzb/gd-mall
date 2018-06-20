package com.gd.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gd.common.util.FtpUtil;
import com.gd.common.util.IDUtils;
import com.gd.service.PictureService;
@Service
public class PictureServiceImpl implements PictureService {

	//获取配置文件resouce.properties的值
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	@SuppressWarnings("rawtypes")
	@Override
	//上传图片
	public Map uploadPicture(MultipartFile uploadFile) throws IOException {
		Map<String, String> resultMap=new HashMap<String,String>();
		try {
			//取原文件名
			String oldName=uploadFile.getOriginalFilename();
			//生成新的文件名
			String newName=IDUtils.getImageName();
			//新的文件名加上原名的后缀名
			newName=newName+oldName.substring(oldName.lastIndexOf("."));
			String imagePath=new DateTime().toString("/yyyy/MM/dd");
			//调用文件上传的工具类
			boolean result=FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, 
					imagePath, newName, uploadFile.getInputStream());
			if(!result){
				resultMap.put("error", "1");
				resultMap.put("message","文件上传失败");
				return resultMap;
			}
			resultMap.put("error", "0");
			resultMap.put("url", IMAGE_BASE_URL+imagePath+"/"+newName);
			return resultMap;
		} catch (Exception e) {
			resultMap.put("error", "1");
			resultMap.put("message","文件上传失败");
			return resultMap;
		}
	}

}
