package com.sust.onlineorder.dao;

import com.sust.onlineorder.entity.TAddress;
import com.sust.onlineorder.entity.TAddressExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TAddressMapper {
    int countByExample(TAddressExample example);

    int deleteByExample(TAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAddress record);

    int insertSelective(TAddress record);

    List<TAddress> selectByExample(TAddressExample example);

    TAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAddress record, @Param("model") TAddressExample example);

    int updateByExample(@Param("record") TAddress record, @Param("model") TAddressExample example);

    int updateByPrimaryKeySelective(TAddress record);

    int updateByPrimaryKey(TAddress record);
}