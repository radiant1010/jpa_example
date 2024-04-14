package com.jpa.demo.example.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExampleRepositoryImpl implements ExampleRepositoryCustom{

    private final JPAQueryFactory queryFactory;

}
