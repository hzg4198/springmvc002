package com.cuit.controller;

import com.cuit.pojo.BaseDict;
import com.cuit.pojo.Customer;
import com.cuit.pojo.QueryVoParams;
import com.cuit.service.BaseDictService;
import com.cuit.service.CustomerService;
import com.cuit.service.Impl.BaseDictServiceImpl;
import com.cuit.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    @Value("${FROMTYPE}")
    private String customerFromType;
    @Value("${INDUSTRYTYPE}")
    private String customerIndustryType;
    @Value("${LEVELTYPE}")
    private String customerLevelType;
    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String queryCustomerList(QueryVoParams params,Model model){
        //客户来源
        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(customerFromType);
        //所属行业
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(customerIndustryType);
        //客户级别
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(customerLevelType);
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        //分页数据查询
        Page<Customer> page = customerService.queryCustomerByQueryVo(params);
        model.addAttribute("page",page);
        return "customer";



    }

}
