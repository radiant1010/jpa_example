package com.jpa.demo.example.domain.repository;

import com.jpa.demo.example.domain.entity.ExampleFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleFileRepository extends JpaRepository<ExampleFile, Long> {
}
