package com.linde.Generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/design?useUnicode=true&useSSL=false&characterEncoding=utf-8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);


        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        globalConfig.setOpen(false);             //设置生成完毕后是否打开生成代码所在的目录
        globalConfig.setAuthor("Linde");        //设置作者
        globalConfig.setFileOverride(true);     //设置是否覆盖原始生成的文件
        globalConfig.setMapperName("%sMapper"); //设置数据层接口名，%s为占位符 指代模块名称
        globalConfig.setIdType(IdType.ASSIGN_ID); //设置id生成策略
        autoGenerator.setGlobalConfig(globalConfig);

        //设置包名相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.linde");
        packageConfig.setEntity("domain");
        packageConfig.setMapper("mapper");
        autoGenerator.setPackageInfo(packageConfig);

        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("tbl_deliver");        //设置当前参与生成的表名，参数为可变参数
        strategyConfig.setTablePrefix("tbl_");          //设置数据库表的前缀名称， 模块名 = 数据库表名 - 前缀名 例如：User = tbl_user
        strategyConfig.setRestControllerStyle(true);    //设置是否启用rest风格
        //strategyConfig.setVersionFieldName("version");  //设置乐观锁字段名
        strategyConfig.setLogicDeleteFieldName("deleted");// 设置逻辑删除字段名
        strategyConfig.setEntityLombokModel(true);      //  设置是否启用lombok
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//下划线转驼峰
        strategyConfig.setControllerMappingHyphenStyle(true);

        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}
