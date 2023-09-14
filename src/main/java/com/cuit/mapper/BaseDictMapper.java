package com.cuit.mapper;

import com.cuit.pojo.BaseDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BaseDictMapper {

    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);



}
