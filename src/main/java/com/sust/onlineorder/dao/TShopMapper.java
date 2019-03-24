package com.sust.onlineorder.dao;

import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.entity.TShopExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TShopMapper {
    int countByExample(TShopExample example);

    int deleteByExample(TShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TShop record);

    int insertSelective(TShop record);

    List<TShop> selectByExample(TShopExample example);

    TShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TShop record, @Param("model") TShopExample example);

    int updateByExample(@Param("record") TShop record, @Param("model") TShopExample example);

    int updateByPrimaryKeySelective(TShop record);

    int updateByPrimaryKey(TShop record);
}