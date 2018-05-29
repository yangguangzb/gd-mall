package com.gd.mapper;

import com.gd.pojo.GdItemCat;
import com.gd.pojo.GdItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdItemCatMapper {
    int countByExample(GdItemCatExample example);

    int deleteByExample(GdItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdItemCat record);

    int insertSelective(GdItemCat record);

    List<GdItemCat> selectByExample(GdItemCatExample example);

    GdItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdItemCat record, @Param("example") GdItemCatExample example);

    int updateByExample(@Param("record") GdItemCat record, @Param("example") GdItemCatExample example);

    int updateByPrimaryKeySelective(GdItemCat record);

    int updateByPrimaryKey(GdItemCat record);
}