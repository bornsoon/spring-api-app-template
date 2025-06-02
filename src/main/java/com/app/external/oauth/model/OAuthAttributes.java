package com.app.external.oauth.model;

import com.app.domain.member.entity.Member;
import com.app.domain.member.constant.MemberType;
import com.app.domain.member.constant.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter @Builder
public class OAuthAttributes {

    private String name;
    private String email;
    private String profile;
    private MemberType memberType;

    // OAuthAttributes 객체를 바탕으로, 저장 가능한 Member 객체로 변환
    public Member toMemberEntity(MemberType memberType, Role role) {
        return Member.builder()
                .memberName(name)
                .email(email)
                .memberType(memberType)
                .profile(profile)
                .role(role)
                .build();
}
    }
