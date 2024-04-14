package com.jpa.demo.ExampleIdGen.domain.repository;

import com.jpa.demo.ExampleIdGen.domain.entity.ExampleIdGen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleIdGenRepository extends JpaRepository<ExampleIdGen, String> {

}
