package com.gd.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.GdResult;
import com.gd.search.service.ItemService;

/**
 * 索引库维护
 * @author zhangbiao
 */
@Controller
@RequestMapping("/manager")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/importall")
	@ResponseBody
	public GdResult importAllItems(){
		GdResult result = itemService.importAllItems();
		return result;
	}
	
}
