package com.jpa.demo.example.domain.dto;

import com.jpa.demo.example.domain.entity.Example;
import com.jpa.demo.example.domain.entity.ExampleFile;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveExampleReqDTO {
    private String id;
    private String password;
    private String email;

    @Builder
    public SaveExampleReqDTO(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }
    
    //DTO를 Entity로 변환
    public Example toEntity(){
        return Example.builder()
                .id(id)
                .password(password)
                .email(email)
                .build();
    }

}
