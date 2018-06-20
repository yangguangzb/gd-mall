package com.gd.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gd.mapper.GdItemCatMapper;
import com.gd.pojo.GdItemCat;
import com.gd.pojo.GdItemCatExample;
import com.gd.pojo.GdItemCatExample.Criteria;
import com.gd.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private GdItemCatMapper itemCatMapper;
	
	//通过获取父节点的所有子节点
	@Override
	public List<GdItemCat> getItemCatList(Long parentId) {
		GdItemCatExample example=new GdItemCatExample();
		Criteria criteria = example.createCriteria();
		//根据parentId查询子节点
		criteria.andParentIdEqualTo(parentId);
		List<GdItemCat> list = itemCatMapper.selectByExample(example);
		return list;
	}

}
