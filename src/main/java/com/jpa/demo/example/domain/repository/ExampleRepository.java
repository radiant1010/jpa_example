package com.jpa.demo.example.domain.repository;

import com.jpa.demo.example.domain.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExampleRepository extends JpaRepository<Example, String>, ExampleRepositoryCustom {

    //단건 수정 | 필요한 쿼리 작성, JPA 사용 안하고 바로 쿼리 사용하도록 하는 코드 nativeQuery 옵션 찾아보기
    @Query("UPDATE Example e SET e.email = :newEmail WHERE e.id = :userId")
    void updateExampleEmail(String userId, String newEmail);

}
