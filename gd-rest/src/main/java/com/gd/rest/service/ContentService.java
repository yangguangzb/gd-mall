package com.gd.rest.service;

import java.util.List;

import com.gd.pojo.GdContent;

public interface ContentService {
	
	public List<GdContent> getContentList(long contentCid);

}
