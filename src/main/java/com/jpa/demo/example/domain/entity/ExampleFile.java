package com.jpa.demo.example.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class ExampleFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String origFilename;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String filePath;

    private Long fileSize;

    @Builder
    public ExampleFile(String origFilename, String filename, String filePath, Long fileSize) {
        this.origFilename = origFilename;
        this.filename = filename;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}