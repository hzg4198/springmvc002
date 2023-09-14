package com.cuit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseDict {
   private String dict_id;
   private String dict_type_code;
   private String dict_type_name;
   private String dict_item_name;
   private String dict_item_code;
   private Integer dict_sort;
   private String dict_enable;
   private String dict_memo;

}
