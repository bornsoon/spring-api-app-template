package com.app.domain.member.repository;

import com.app.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // repository 계층는 service 계층을 통해서만 사용하면 유지보수가 수월

    // JPA 에서 제공하는 쿼리 메소드 기능에 의해서 이메일 기반으로 멤버 찾아줌
    Optional<Member> findByEmail(String email);

    Optional<Member> findByRefreshToken(String refreshToken);
}
