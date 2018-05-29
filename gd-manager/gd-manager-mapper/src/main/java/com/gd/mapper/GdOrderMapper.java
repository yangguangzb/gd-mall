package com.gd.mapper;

import com.gd.pojo.GdOrder;
import com.gd.pojo.GdOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdOrderMapper {
    int countByExample(GdOrderExample example);

    int deleteByExample(GdOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(GdOrder record);

    int insertSelective(GdOrder record);

    List<GdOrder> selectByExample(GdOrderExample example);

    GdOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") GdOrder record, @Param("example") GdOrderExample example);

    int updateByExample(@Param("record") GdOrder record, @Param("example") GdOrderExample example);

    int updateByPrimaryKeySelective(GdOrder record);

    int updateByPrimaryKey(GdOrder record);
}