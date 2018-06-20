package com.gd.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gd.pojo.GdItemCat;
import com.gd.service.ItemCatService;

/**
 * 商品类别
 * @description
 * @author zhangbiao
 * @time 2018-6-18 下午7:24:28
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@SuppressWarnings({"rawtypes","unchecked"})
	@RequestMapping("/list")
	@ResponseBody
	//设置默认值为0，防止为null
	public List categoryList(@RequestParam(value="id",defaultValue="0")Long parentId){
		List catList=new ArrayList();
		List<GdItemCat> list = itemCatService.getItemCatList(parentId);
		for (GdItemCat gdItemCat : list) {
			Map node=new HashMap();
			node.put("id", gdItemCat.getId());
			node.put("text", gdItemCat.getName());
			//如果是父节点的话就设置为关闭状态，如果是子节点的话就设置为open状态
			node.put("state", gdItemCat.getIsParent()?"closed":"open");
			catList.add(node);
		}
		return catList;
	}
}
