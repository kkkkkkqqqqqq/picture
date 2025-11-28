package com.qiukun.qiukunpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.qiukun.qiukunpicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class QiukunPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QiukunPictureBackendApplication.class, args);
    }

}
