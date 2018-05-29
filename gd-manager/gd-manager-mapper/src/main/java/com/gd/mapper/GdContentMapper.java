package com.gd.mapper;

import com.gd.pojo.GdContent;
import com.gd.pojo.GdContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdContentMapper {
    int countByExample(GdContentExample example);

    int deleteByExample(GdContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdContent record);

    int insertSelective(GdContent record);

    List<GdContent> selectByExampleWithBLOBs(GdContentExample example);

    List<GdContent> selectByExample(GdContentExample example);

    GdContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdContent record, @Param("example") GdContentExample example);

    int updateByExampleWithBLOBs(@Param("record") GdContent record, @Param("example") GdContentExample example);

    int updateByExample(@Param("record") GdContent record, @Param("example") GdContentExample example);

    int updateByPrimaryKeySelective(GdContent record);

    int updateByPrimaryKeyWithBLOBs(GdContent record);

    int updateByPrimaryKey(GdContent record);
}