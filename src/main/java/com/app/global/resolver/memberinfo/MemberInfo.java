package com.app.global.resolver.memberinfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 컨트롤러 메소드에 @MemberInfo 붙이고 MemberInfoDto 객체 전달
@Target(ElementType.PARAMETER)  // annotation이 적용될 위치
@Retention(RetentionPolicy.RUNTIME)  // annotation이 유지되는 범위 (RUNTIME: 컴파일 이후에도 JVM에서 계속 참조가 가능)
public @interface MemberInfo {
}
