package com.gd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.common.pojo.EUDataGridResult;
import com.gd.common.pojo.GdResult;
import com.gd.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/query/itemcatid/{itemCatid}")
	@ResponseBody
	public GdResult getItemParamByCid(@PathVariable Long itemCatId){
		GdResult result = itemParamService.getItemParamByCid(itemCatId);
		return result;
	}
	
	//参数列表
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemParamList(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="30")Integer rows){
		EUDataGridResult result = itemParamService.getItemParamList(page, rows);
		System.out.println("商品规格参数:"+result.getRows());
		return result;
	}
}
