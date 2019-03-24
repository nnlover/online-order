package com.sust.onlineorder.dao;

import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TFoodExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TFoodMapper {
    int countByExample(TFoodExample example);

    int deleteByExample(TFoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFood record);

    int insertSelective(TFood record);

    List<TFood> selectByExample(TFoodExample example);

    TFood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFood record, @Param("model") TFoodExample example);

    int updateByExample(@Param("record") TFood record, @Param("model") TFoodExample example);

    int updateByPrimaryKeySelective(TFood record);

    int updateByPrimaryKey(TFood record);
}