package com.gd.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
	
	//上传图片
	@SuppressWarnings("rawtypes")
	Map uploadPicture(MultipartFile uploadFile) throws IOException;
	
}
