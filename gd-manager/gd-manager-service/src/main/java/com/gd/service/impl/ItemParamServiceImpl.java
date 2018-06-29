package com.gd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.EUDataGridResult;
import com.gd.common.pojo.GdResult;
import com.gd.mapper.GdItemParamMapper;
import com.gd.pojo.GdItemParam;
import com.gd.pojo.GdItemParamExample;
import com.gd.pojo.GdItemParamExample.Criteria;
import com.gd.service.ItemParamService;
import com.github.pagehelper.PageHelper;
@Service
public class ItemParamServiceImpl implements ItemParamService{

	@Autowired
	private GdItemParamMapper itemParamMapper;
	
	//通过id获得商品规格参数
	@Override
	public GdResult getItemParamByCid(Long cid) {
		GdItemParamExample example=new GdItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<GdItemParam> list = itemParamMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return GdResult.ok(list.get(0));
		}
		return GdResult.ok();
	}

	//插入商品规格参数
	@Override
	public GdResult insertItemParam(GdItemParam itemParam) {
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		itemParamMapper.insert(itemParam);
		return GdResult.ok();
	}
	
	//显示商品规格参数
	@Override
	public EUDataGridResult getItemParamList(Integer page, Integer rows) {
		GdItemParamExample paramExample = new GdItemParamExample();
		PageHelper.startPage(page, rows);
		List<GdItemParam> list = itemParamMapper.selectByExample(paramExample);
		//创建一个返回对象
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(list);
		result.setTotal(list.size());
		return result;
	}

}
