package com.gd.mapper;

import com.gd.pojo.GdItemDesc;
import com.gd.pojo.GdItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdItemDescMapper {
    int countByExample(GdItemDescExample example);

    int deleteByExample(GdItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(GdItemDesc record);

    int insertSelective(GdItemDesc record);

    List<GdItemDesc> selectByExampleWithBLOBs(GdItemDescExample example);

    List<GdItemDesc> selectByExample(GdItemDescExample example);

    GdItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") GdItemDesc record, @Param("example") GdItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") GdItemDesc record, @Param("example") GdItemDescExample example);

    int updateByExample(@Param("record") GdItemDesc record, @Param("example") GdItemDescExample example);

    int updateByPrimaryKeySelective(GdItemDesc record);

    int updateByPrimaryKeyWithBLOBs(GdItemDesc record);

    int updateByPrimaryKey(GdItemDesc record);
}