package com.gd.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.EUDataGridResult;
import com.gd.common.pojo.GdResult;
import com.gd.common.util.IDUtils;
import com.gd.mapper.GdItemDescMapper;
import com.gd.mapper.GdItemMapper;
import com.gd.mapper.GdItemParamItemMapper;
import com.gd.pojo.GdItem;
import com.gd.pojo.GdItemDesc;
import com.gd.pojo.GdItemExample;
import com.gd.pojo.GdItemExample.Criteria;
import com.gd.pojo.GdItemParamItem;
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
	
	@Autowired
	private GdItemDescMapper itemDescMapper;
	
	@Autowired
	private GdItemParamItemMapper itemParamItemMapper;
	
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

	//添加商品
	public GdResult createItem(GdItem item, String desc, String itemParam) throws Exception{
		//生成商品的ID
		long itemId = IDUtils.getItemId();
		item.setId(itemId);
		//商品状态，1-正常  2-下架  3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(item);
		//添加商品描述信息
		GdResult result = insertItemDesc(itemId, desc);
		if(result.getStatus()!=200){
			throw new Exception();
		}
		//添加
		return result;
	}
	
	//添加商品描述信息
	private GdResult insertItemDesc(Long itemid, String desc) {
		GdItemDesc itemDesc=new GdItemDesc();
		itemDesc.setItemId(itemid);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return GdResult.ok();
	}
	
	//添加规格参数
	@SuppressWarnings("unused")
	private GdResult insertItemParamItem(Long itemId,String itemParam){
		GdItemParamItem itemParamItem = new GdItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表格中插入数据
		itemParamItemMapper.insert(itemParamItem);
		return GdResult.ok();
	}
}
