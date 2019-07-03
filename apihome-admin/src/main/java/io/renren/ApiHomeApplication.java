/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//前3个注解都是为了maven子模块的其他标签的拆分。
@ComponentScan(basePackages = {"apihome","io.renren"})
@EnableTransactionManagement
@MapperScan({"apihome.modules.*.dao","io.renren.modules.*.dao"})
@SpringBootApplication
public class ApiHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHomeApplication.class, args);
	}

}