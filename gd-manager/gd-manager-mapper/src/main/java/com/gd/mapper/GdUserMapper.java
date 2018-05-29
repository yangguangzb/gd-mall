package com.gd.mapper;

import com.gd.pojo.GdUser;
import com.gd.pojo.GdUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdUserMapper {
    int countByExample(GdUserExample example);

    int deleteByExample(GdUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdUser record);

    int insertSelective(GdUser record);

    List<GdUser> selectByExample(GdUserExample example);

    GdUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdUser record, @Param("example") GdUserExample example);

    int updateByExample(@Param("record") GdUser record, @Param("example") GdUserExample example);

    int updateByPrimaryKeySelective(GdUser record);

    int updateByPrimaryKey(GdUser record);
}