package com.cuit.service;

import com.cuit.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
