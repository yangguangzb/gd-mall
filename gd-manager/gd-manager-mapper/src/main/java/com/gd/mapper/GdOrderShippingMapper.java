package com.gd.mapper;

import com.gd.pojo.GdOrderShipping;
import com.gd.pojo.GdOrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdOrderShippingMapper {
    int countByExample(GdOrderShippingExample example);

    int deleteByExample(GdOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(GdOrderShipping record);

    int insertSelective(GdOrderShipping record);

    List<GdOrderShipping> selectByExample(GdOrderShippingExample example);

    GdOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") GdOrderShipping record, @Param("example") GdOrderShippingExample example);

    int updateByExample(@Param("record") GdOrderShipping record, @Param("example") GdOrderShippingExample example);

    int updateByPrimaryKeySelective(GdOrderShipping record);

    int updateByPrimaryKey(GdOrderShipping record);
}