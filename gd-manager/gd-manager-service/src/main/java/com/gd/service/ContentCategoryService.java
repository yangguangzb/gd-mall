package com.gd.service;

import java.util.List;

import com.gd.common.pojo.EUTreeNode;
import com.gd.common.pojo.GdResult;

public interface ContentCategoryService {
	
	public List<EUTreeNode> getCategoryList(long parentId);
	
	GdResult insertContentCategory(long parentId, String name); 
}
