package com.sust.onlineorder.dao;

import com.sust.onlineorder.entity.TActivity;
import com.sust.onlineorder.entity.TActivityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TActivityMapper {
    int countByExample(TActivityExample example);

    int deleteByExample(TActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    List<TActivity> selectByExample(TActivityExample example);

    TActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByExample(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKey(TActivity record);
}