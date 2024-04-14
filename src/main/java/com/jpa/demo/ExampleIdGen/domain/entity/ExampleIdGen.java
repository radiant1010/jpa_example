package com.jpa.demo.ExampleIdGen.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExampleIdGen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    private String prefix;

    private Integer intervalValue; // 증가값

    private String digit; // Id 자릿수
    
    private Integer lastIdx; // 마지막 Id 값

}
