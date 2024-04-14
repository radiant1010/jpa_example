package com.jpa.demo.example.service;

import com.jpa.demo.example.domain.entity.Example;
import com.jpa.demo.example.domain.repository.ExampleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExampleServiceTest {

    @Autowired
    private ExampleService exampleService;

    @MockBean // Mock 객체 사용하여 실제 DB 상호작용 방지
    private ExampleRepository exampleRepository;

    @Test
    public void testCreateExample() {
        String id = "test-id";
        String password = "test-password";
        String email = "test@example.com";


        exampleRepository.save(Example.builder()
                .id(id)
                .password(password)
                .email(email)
                .build());

        Optional<Example> findDto = exampleRepository.findById(id);

    }


}