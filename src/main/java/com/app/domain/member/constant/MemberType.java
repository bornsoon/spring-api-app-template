package com.app.domain.member.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MemberType {

    KAKAO;

    public static MemberType from(String type) {
        // String 값을 enum에서 가져옴. 값이 없으면 예외 발생
        return MemberType.valueOf(type.toUpperCase());
    }

    public static boolean isMemberType(String type) {
        List<MemberType> memberTypes = Arrays.stream(MemberType.values())
                .filter(memberType -> memberType.name().equals(type))
                .collect(Collectors.toList());
        return memberTypes.size() != 0;  // MemberType에 해당하면 1, 아니면 0

    }
}
