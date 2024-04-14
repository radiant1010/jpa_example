package com.jpa.demo.ExampleIdGen.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QIdGenerator is a Querydsl query type for IdGenerator
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIdGenerator extends EntityPathBase<ExampleIdGen> {

    private static final long serialVersionUID = 1376503158L;

    public static final QIdGenerator idGenerator = new QIdGenerator("idGenerator");

    public final StringPath digit = createString("digit");

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    public final NumberPath<Integer> intervalValue = createNumber("intervalValue", Integer.class);

    public final NumberPath<Integer> lastIdx = createNumber("lastIdx", Integer.class);

    public final StringPath prefix = createString("prefix");

    public QIdGenerator(String variable) {
        super(ExampleIdGen.class, forVariable(variable));
    }

    public QIdGenerator(Path<? extends ExampleIdGen> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIdGenerator(PathMetadata metadata) {
        super(ExampleIdGen.class, metadata);
    }

}

