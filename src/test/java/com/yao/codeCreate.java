package com.yao;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

//代码自动生成器
public class codeCreate {

    public static void main(String[] args) {
        //g构建一个代码生成器对象
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("yy");
        gc.setOpen(false);
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService");//去除service的i前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dc = new DataSourceConfig();

        dc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&useSSL=true&serverTimezone=GMT%2B8");
        dc.setUsername("root");
        dc.setPassword("123456");
        dc.setDriverName("com.mysql.jdbc.Driver");
        dc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dc);

        //三 包的配置
        PackageConfig pc = new PackageConfig();
        pc.setController("controller");
        pc.setModuleName("picture");
        pc.setParent("com.yao");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        mpg.setPackageInfo(pc);

        //四 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("picture");//这里修改表明就可以
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);

        sc.setLogicDeleteFieldName("deleted");
        //自动填充
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> list = new ArrayList<>();
        list.add(gmtCreate);
        list.add(gmtModified);
        sc.setTableFillList(list);
        //乐观锁
        sc.setVersionFieldName("version");
        //开启驼峰命名
        sc.setRestControllerStyle(true);
       //使用rest风格
        sc.setControllerMappingHyphenStyle(true);//localhost:8080/hello_id_2
        mpg.setStrategy(sc);
        //执行
        mpg.execute();
    }
}
