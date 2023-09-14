package com.cuit.service.Impl;

import com.cuit.mapper.CustomerMapper;
import com.cuit.pojo.Customer;
import com.cuit.pojo.QueryVoParams;
import com.cuit.service.CustomerService;
import com.cuit.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVoParams vo) {
        //从哪一条开始查询
        vo.setStart((vo.getPage()-1)*vo.getRows());
        //查询数据结果集合
        int total = customerMapper.queryCountByQueryVo(vo);
        //查询到的总数据
        List<Customer> list = customerMapper.queryCustomerByQueryVo(vo);
        //返回封装的page对象
        return new Page<>(total, vo.getPage(), vo.getRows(),list);
    }
}
