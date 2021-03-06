package com.yao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  // @TableId(type = IdType.ID_WORKER )
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @Version
    private Integer version;
    @TableLogic//逻辑删除
    private Integer deleted;

   @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    //CURRENT_TIMESTAMP
  
   @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
