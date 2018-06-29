package com.gd.service;

import com.gd.common.pojo.EUDataGridResult;
import com.gd.common.pojo.GdResult;
import com.gd.pojo.GdItemParam;
/**
 * 商品规格参数
 * @description
 * @author zhangbiao
 * @time 2018-6-21 下午8:45:31
 */
public interface ItemParamService {
	
	//通过id获得商品规格参数
	GdResult getItemParamByCid(Long cid);
	
	//插入商品规格参数
	GdResult insertItemParam(GdItemParam itemParam);
	
	//显示商品规格参数
	EUDataGridResult getItemParamList(Integer page,Integer rows);
}
