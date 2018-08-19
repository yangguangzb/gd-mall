package com.gd.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.common.pojo.EUTreeNode;
import com.gd.common.pojo.GdResult;
import com.gd.mapper.GdContentCategoryMapper;
import com.gd.pojo.GdContentCategory;
import com.gd.pojo.GdContentCategoryExample;
import com.gd.pojo.GdContentCategoryExample.Criteria;
import com.gd.service.ContentCategoryService;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private GdContentCategoryMapper contentCategoryMapper;
	
	//返回结点列表
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		//根据parentId查询结点列表
		GdContentCategoryExample example = new GdContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<GdContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<EUTreeNode>();
		for(GdContentCategory gdContentCategory : list){
			//创建一个结点
			EUTreeNode node = new EUTreeNode();
			node.setId(gdContentCategory.getId());
			node.setText(gdContentCategory.getName());
			node.setState(gdContentCategory.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}
	
	//内容分类添加
	@Override
	public GdResult insertContentCategory(long parentId, String name) {
		
		//创建一个pojo
		GdContentCategory contentCategory = new GdContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//状态。可选值:1(正常),2(删除)
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是，则改为true
		GdContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!parentCat.getIsParent()){
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		
		return GdResult.ok(contentCategory);
	}

}
