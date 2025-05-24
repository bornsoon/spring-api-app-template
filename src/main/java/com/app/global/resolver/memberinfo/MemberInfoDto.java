package com.app.global.resolver.memberinfo;

import com.app.domain.member.constant.Role;
import lombok.Builder;
import lombok.Getter;

// 컨트롤러 메소드에 @MemberInfo 붙이고 MemberInfoDto 객체 전달
@Getter @Builder
public class MemberInfoDto {

    private Long memberId;
    private Role role;

}
