package com.jpa.demo.ExampleIdGen.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExampleIdGen is a Querydsl query type for ExampleIdGen
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExampleIdGen extends EntityPathBase<ExampleIdGen> {

    private static final long serialVersionUID = -1314309436L;

    public static final QExampleIdGen exampleIdGen = new QExampleIdGen("exampleIdGen");

    public final StringPath digit = createString("digit");

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    public final NumberPath<Integer> intervalValue = createNumber("intervalValue", Integer.class);

    public final NumberPath<Integer> lastIdx = createNumber("lastIdx", Integer.class);

    public final StringPath prefix = createString("prefix");

    public QExampleIdGen(String variable) {
        super(ExampleIdGen.class, forVariable(variable));
    }

    public QExampleIdGen(Path<? extends ExampleIdGen> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExampleIdGen(PathMetadata metadata) {
        super(ExampleIdGen.class, metadata);
    }

}

