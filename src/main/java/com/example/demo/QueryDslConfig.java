package com.example.demo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // @Entity로 관리되는 JPA 엔터티들의 상태 변화를 감시하는 기능을 킨다는 뜻
public class QueryDslConfig {
    @PersistenceContext // @PersistenceContext 는 EntityManager 에 의존성 주입을 담당하는 Annotation
    private EntityManager entityManager; // EntityManager 는 JPA 에서 엔터티의 생성, 조회, 수정 삭제를 수행하는 객체

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        // 쿼리를 작성하는 JPAQueryFactory 에 EntityManager 를 넘겨 사용
        return new JPAQueryFactory(entityManager);
    }
}
