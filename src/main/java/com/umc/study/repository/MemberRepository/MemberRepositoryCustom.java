package com.umc.study.repository.MemberRepository;

import com.umc.study.domain.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> mypage (Long id);
}
