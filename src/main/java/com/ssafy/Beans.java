package com.ssafy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration // xml 안쓰고 자바로 하겠다
@MapperScan("com.ssafy.**.model.dao")
public class Beans {

}