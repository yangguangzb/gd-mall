package com.gd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gd.service.ItemParamItemService;


@Controller
public class ItemParamItemController {
	
	@Autowired
	private ItemParamItemService itemParamItemService;
	
	//显示规格参数html
	@RequestMapping("/item/{itemId}")
	public String showItemParam(@PathVariable Long itemId, Model model){
		String string = itemParamItemService.getItemParamByItemId(itemId);
		model.addAttribute("itemParam",string);
		return "item";
	}

	
}
