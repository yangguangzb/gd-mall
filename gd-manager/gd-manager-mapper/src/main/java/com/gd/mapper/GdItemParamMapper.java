package com.gd.mapper;

import com.gd.pojo.GdItemParam;
import com.gd.pojo.GdItemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdItemParamMapper {
    int countByExample(GdItemParamExample example);

    int deleteByExample(GdItemParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdItemParam record);

    int insertSelective(GdItemParam record);

    List<GdItemParam> selectByExampleWithBLOBs(GdItemParamExample example);

    List<GdItemParam> selectByExample(GdItemParamExample example);

    GdItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdItemParam record, @Param("example") GdItemParamExample example);

    int updateByExampleWithBLOBs(@Param("record") GdItemParam record, @Param("example") GdItemParamExample example);

    int updateByExample(@Param("record") GdItemParam record, @Param("example") GdItemParamExample example);

    int updateByPrimaryKeySelective(GdItemParam record);

    int updateByPrimaryKeyWithBLOBs(GdItemParam record);

    int updateByPrimaryKey(GdItemParam record);
}