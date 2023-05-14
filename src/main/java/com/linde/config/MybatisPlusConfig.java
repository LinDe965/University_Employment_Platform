package com.linde.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;

@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1 创建MybatisPlusInterceptor拦截器对象
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //2 添加分页拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                // 设置创建时间为当前时间
                this.strictInsertFill(metaObject, "positionCreateTime", LocalDateTime.class, LocalDateTime.now());
                this.strictInsertFill(metaObject, "studentFavoritesTime", LocalDateTime.class, LocalDateTime.now());
                this.strictInsertFill(metaObject, "deliverTime", LocalDateTime.class, LocalDateTime.now());
                this.strictInsertFill(metaObject, "interviewTime", LocalDateTime.class, LocalDateTime.now());
                this.strictInsertFill(metaObject, "signingTime", LocalDateTime.class, LocalDateTime.now());
                this.strictUpdateFill(metaObject, "deleted", Integer.class, 0);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                // 设置更新时间为当前时间
                //this.strictUpdateFill(metaObject, "positionUpdateTime", LocalDateTime.class, LocalDateTime.now());
                this.strictUpdateFill(metaObject, "deleted", Integer.class, 1);
            }
        };
    }
}
