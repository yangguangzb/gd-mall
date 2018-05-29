package com.gd.mapper;

import com.gd.pojo.GdItemParamItem;
import com.gd.pojo.GdItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdItemParamItemMapper {
    int countByExample(GdItemParamItemExample example);

    int deleteByExample(GdItemParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdItemParamItem record);

    int insertSelective(GdItemParamItem record);

    List<GdItemParamItem> selectByExampleWithBLOBs(GdItemParamItemExample example);

    List<GdItemParamItem> selectByExample(GdItemParamItemExample example);

    GdItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdItemParamItem record, @Param("example") GdItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") GdItemParamItem record, @Param("example") GdItemParamItemExample example);

    int updateByExample(@Param("record") GdItemParamItem record, @Param("example") GdItemParamItemExample example);

    int updateByPrimaryKeySelective(GdItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(GdItemParamItem record);

    int updateByPrimaryKey(GdItemParamItem record);
}