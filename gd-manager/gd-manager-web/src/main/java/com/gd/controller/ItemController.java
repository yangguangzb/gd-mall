package com.gd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.EUDataGridResult;
import com.gd.service.ItemService;

/**
 * 商品管理Controller
 * @description
 * @author zhangbiao
 * @time 2018-6-18 下午4:08:37
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	//商品列表
	@RequestMapping("/list")
	@ResponseBody	//设置数据为json
	public EUDataGridResult getItemList(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="30")Integer rows){
		EUDataGridResult result=itemService.getItemList(page, rows);
		return result;
	}
	
	
	
}
