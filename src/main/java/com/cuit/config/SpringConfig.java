package com.cuit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({JdbcConfig.class,MybatisConfig.class})
@PropertySource({"classpath:jdbc.properties","classpath:env.properties"})
@ComponentScan({"com.cuit.config","com.cuit.service"})
public class SpringConfig {
}
