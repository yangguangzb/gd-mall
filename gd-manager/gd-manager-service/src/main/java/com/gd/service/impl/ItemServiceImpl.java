package com.gd.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.EUDataGridResult;
import com.gd.mapper.GdItemMapper;
import com.gd.pojo.GdItem;
import com.gd.pojo.GdItemExample;
import com.gd.pojo.GdItemExample.Criteria;
import com.gd.service.ItemService;
import com.github.pagehelper.PageHelper;
/**
 * 商品管理的Service
 * @description
 * @author zhangbiao
 * @time 2018-6-18 下午3:50:33
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private GdItemMapper itemMapper;
	
	//根据编号获取商品信息
	@Override
	public GdItem getItemById(long itemId) {
		//添加查询条件
		GdItemExample example=new GdItemExample();
		Criteria create = example.createCriteria();
		create.andIdEqualTo(itemId);
		List<GdItem> list = itemMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			GdItem item=list.get(0);
			return item;
		}
		return null;
	}
	
	//根据页和每页大小获取商品
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		GdItemExample example=new GdItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<GdItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(list);
		result.setTotal(list.size());
		return result;
	}
	
	
}
