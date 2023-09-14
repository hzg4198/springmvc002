package com.cuit.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Customer {
    private Long  cust_id;
    private  String          cust_name;
    private Long  cust_user_id;
    private  Long          cust_create_id;
    private String  cust_source;
    private  String          cust_industry;
    private String  cust_level;
    private  String          cust_linkman;
    private String  cust_phone;
    private  String          cust_mobile;
    private String  cust_zipcode;
    private  String          cust_address;
    private Date cust_createtime;

}
