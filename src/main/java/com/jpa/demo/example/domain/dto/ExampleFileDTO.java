package com.jpa.demo.example.domain.dto;

import com.jpa.demo.example.domain.entity.ExampleFile;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExampleFileDTO {

    private String origFilename;
    private String filename;
    private String filePath;

    @Builder
    public ExampleFileDTO(String origFilename, String filename, String filePath) {
        this.origFilename = origFilename;
        this.filename = filename;
        this.filePath = filePath;
    }
    
    //DTO를 Entity로 변환해줄때
    public ExampleFile toEntity() {
        return ExampleFile.builder()
                .origFilename(origFilename)
                .filename(filename)
                .filePath(filePath)
                .build();
    }
}
