package com.gd.service;
import java.util.List;
import com.gd.pojo.GdItemCat;

public interface ItemCatService {
	//通过获取父节点的所有子节点
	List<GdItemCat> getItemCatList(Long parentId);
}
