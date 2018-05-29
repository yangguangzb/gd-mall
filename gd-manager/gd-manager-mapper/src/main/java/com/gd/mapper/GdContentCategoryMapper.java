package com.gd.mapper;

import com.gd.pojo.GdContentCategory;
import com.gd.pojo.GdContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdContentCategoryMapper {
    int countByExample(GdContentCategoryExample example);

    int deleteByExample(GdContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdContentCategory record);

    int insertSelective(GdContentCategory record);

    List<GdContentCategory> selectByExample(GdContentCategoryExample example);

    GdContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdContentCategory record, @Param("example") GdContentCategoryExample example);

    int updateByExample(@Param("record") GdContentCategory record, @Param("example") GdContentCategoryExample example);

    int updateByPrimaryKeySelective(GdContentCategory record);

    int updateByPrimaryKey(GdContentCategory record);
}