package com.sust.onlineorder.dao;

import com.sust.onlineorder.entity.TCollection;
import com.sust.onlineorder.entity.TCollectionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TCollectionMapper {
    int countByExample(TCollectionExample example);

    int deleteByExample(TCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCollection record);

    int insertSelective(TCollection record);

    List<TCollection> selectByExample(TCollectionExample example);

    TCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCollection record, @Param("example") TCollectionExample example);

    int updateByExample(@Param("record") TCollection record, @Param("example") TCollectionExample example);

    int updateByPrimaryKeySelective(TCollection record);

    int updateByPrimaryKey(TCollection record);
}