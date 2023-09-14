package com.cuit.mapper;

import com.cuit.pojo.Customer;
import com.cuit.pojo.QueryVoParams;

import java.util.List;

public interface CustomerMapper {
    //根据queryVo分页查询数据
    List<Customer> queryCustomerByQueryVo(QueryVoParams vo);
    //根据queryVo查询数据条数
    int queryCountByQueryVo(QueryVoParams vo);
}
