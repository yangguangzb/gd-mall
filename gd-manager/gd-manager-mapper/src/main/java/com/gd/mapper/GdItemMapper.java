package com.gd.mapper;

import com.gd.pojo.GdItem;
import com.gd.pojo.GdItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdItemMapper {
    int countByExample(GdItemExample example);

    int deleteByExample(GdItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdItem record);

    int insertSelective(GdItem record);

    List<GdItem> selectByExample(GdItemExample example);

    GdItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdItem record, @Param("example") GdItemExample example);

    int updateByExample(@Param("record") GdItem record, @Param("example") GdItemExample example);

    int updateByPrimaryKeySelective(GdItem record);

    int updateByPrimaryKey(GdItem record);
}