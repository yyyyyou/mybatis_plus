package com.yao.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
//自动插入时间
@Component
@Slf4j
public class MyDataHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
    log.info("插入开始了；；；；；；");
    this.setFieldValByName("gmcCreate",new Date(),metaObject);
    this.setFieldValByName("gmcModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新开始了；；；；；；");
        this.setFieldValByName("gmcModified",new Date(),metaObject);
    }
}
