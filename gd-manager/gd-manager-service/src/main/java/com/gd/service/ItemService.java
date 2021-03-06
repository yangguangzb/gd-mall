package com.gd.service;

import com.gd.common.pojo.EUDataGridResult;
import com.gd.common.pojo.GdResult;
import com.gd.pojo.GdItem;

public interface ItemService {
	
	//根据编号获取商品信息
	GdItem getItemById(long itemId);
	
	//根据页和每页大小获取商品
	EUDataGridResult getItemList(int page,int rows);
	
	//添加商品
	GdResult createItem(GdItem item,String desc,String itemParam) throws Exception;
	
}
