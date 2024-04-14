package com.jpa.demo.example.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateExampleReqDTO {
    private String id;
    private String email;
}
