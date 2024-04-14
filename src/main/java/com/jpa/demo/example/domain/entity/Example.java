package com.jpa.demo.example.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.boot.model.naming.Identifier;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@EntityListeners(AuditingEntityListener.class) //날짜 등록, 업데이트 자동으로 기입
@DynamicUpdate //변경 사항이 있는 컬럼만 업데이트
public class Example {

    @Id
    @Column(nullable = false, unique = true, length = 50)
    private String id; // 채번 테이블에서 데이터를 받아올 예정

    private String password;

    private String email;

    @Builder
    public Example(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    //JPA Dirty Checking update
    public void updateEmail(String email){
        this.email = email;
    }

}
