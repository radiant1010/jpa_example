package com.jpa.demo.example.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExample is a Querydsl query type for Example
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExample extends EntityPathBase<Example> {

    private static final long serialVersionUID = -1387921318L;

    public static final QExample example = new QExample("example");

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final StringPath password = createString("password");

    public QExample(String variable) {
        super(Example.class, forVariable(variable));
    }

    public QExample(Path<? extends Example> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExample(PathMetadata metadata) {
        super(Example.class, metadata);
    }

}

