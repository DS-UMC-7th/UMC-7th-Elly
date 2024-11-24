package com.umc.study.service.MemberService;

import com.umc.study.domain.Member;
import com.umc.study.web.dto.MemberRequest;

public interface MemberCommandService {
    Member joinMember(MemberRequest.JoinDto request);
}
