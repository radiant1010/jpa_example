package com.jpa.demo.example.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExampleFile is a Querydsl query type for ExampleFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExampleFile extends EntityPathBase<ExampleFile> {

    private static final long serialVersionUID = -1621381898L;

    public static final QExampleFile exampleFile = new QExampleFile("exampleFile");

    public final StringPath filename = createString("filename");

    public final StringPath filePath = createString("filePath");

    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath origFilename = createString("origFilename");

    public QExampleFile(String variable) {
        super(ExampleFile.class, forVariable(variable));
    }

    public QExampleFile(Path<? extends ExampleFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExampleFile(PathMetadata metadata) {
        super(ExampleFile.class, metadata);
    }

}

