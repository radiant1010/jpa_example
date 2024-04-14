package com.jpa.demo.example.domain.dto;

import com.jpa.demo.example.domain.entity.Example;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class FindExampleDTO {
    private String id;
    private String email;

    @Builder
    public FindExampleDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }

    // Entity를 DTO로 변환할때
    public static FindExampleDTO toEntity(Example example) {
        return FindExampleDTO.builder()
                .id(example.getId())
                .email(example.getEmail())
                .build();
    }
}
