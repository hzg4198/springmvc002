package com.cuit.service.Impl;

import com.cuit.mapper.BaseDictMapper;
import com.cuit.pojo.BaseDict;
import com.cuit.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override

    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        return  baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
    }
}
