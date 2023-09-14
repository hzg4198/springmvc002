package com.cuit.pojo;

import lombok.Data;

@Data
public class QueryVoParams {
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    //当前页面数
    private Integer page = 1;
    //数据库从哪一条数据开始查
    private  Integer start;
    //每页显示的条数
    private Integer rows = 4;
}
