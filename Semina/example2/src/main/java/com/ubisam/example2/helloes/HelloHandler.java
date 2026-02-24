package com.ubisam.example2.helloes;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class HelloHandler {

    //중간을 캐치
    @HandleBeforeCreate
    public void beforeCreate(Hello hello){

        //강제로 데이터를 세팅
        // hello.setName("abc");

        //역할 제한
        // throw new RuntimeException();

        System.out.println("22222222222222222222222222222222222");
    }

    @HandleAfterCreate
    public void afterCreate(Hello hello){
        //오디에이팅(로그찍기)
        System.out.println("111111111111111111111111111111111111111");
    }
}
