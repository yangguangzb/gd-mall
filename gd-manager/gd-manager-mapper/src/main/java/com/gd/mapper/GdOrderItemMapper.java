package com.gd.mapper;

import com.gd.pojo.GdOrderItem;
import com.gd.pojo.GdOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdOrderItemMapper {
    int countByExample(GdOrderItemExample example);

    int deleteByExample(GdOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(GdOrderItem record);

    int insertSelective(GdOrderItem record);

    List<GdOrderItem> selectByExample(GdOrderItemExample example);

    GdOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GdOrderItem record, @Param("example") GdOrderItemExample example);

    int updateByExample(@Param("record") GdOrderItem record, @Param("example") GdOrderItemExample example);

    int updateByPrimaryKeySelective(GdOrderItem record);

    int updateByPrimaryKey(GdOrderItem record);
}