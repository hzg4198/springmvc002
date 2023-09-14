package com.cuit.service;

import com.cuit.pojo.Customer;
import com.cuit.pojo.QueryVoParams;
import com.cuit.utils.Page;

public interface CustomerService {
    //根据条件分页查询客户
    Page<Customer> queryCustomerByQueryVo(QueryVoParams vo);
}
