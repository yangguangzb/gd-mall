package com.gd.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.mapper.GdItemCatMapper;
import com.gd.pojo.GdItemCat;
import com.gd.pojo.GdItemCatExample;
import com.gd.pojo.GdItemCatExample.Criteria;
import com.gd.rest.pojo.CatNode;
import com.gd.rest.pojo.CatResult;
import com.gd.rest.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	@Autowired
	private GdItemCatMapper itemCatMapper;
	
	public CatResult getItemCatList() {
		
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0));
		return catResult;
	}
	
	//查询分类列表
	private List<?> getCatList(long parentId){
		//创建查询条件
		GdItemCatExample example = new GdItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<GdItemCat> list = itemCatMapper.selectByExample(example);
		//返回值list
		List resultList = new ArrayList<CatNode>();
		int count = 0;
		//向list中添加结点
		for(GdItemCat gdItemCat : list){
			
			//判断是否为父节点
			if(gdItemCat.getIsParent()){
				CatNode catNode = new CatNode();
				if(parentId == 0){
					//如果是第一层需要加一个a标签
					catNode.setName("<a href='/products/"+gdItemCat.getId()+".html'>"+gdItemCat.getName()+"</a>");
				}else{
					catNode.setName(gdItemCat.getName());
				}
				catNode.setUrl("/products/"+gdItemCat.getId()+".html");
				catNode.setItem(getCatList(gdItemCat.getId()));
				resultList.add(catNode);
				count++;
				//第一层只取14条记录
				if(parentId == 0 && count >= 14){
					break;
				}
			}else{
				//如果是叶子结点
				resultList.add("/products/"+gdItemCat.getId()+".html|" + gdItemCat.getName());
			}
			
		}
		return resultList;
	}

}
