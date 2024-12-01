package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.converter.MemberConverter;
import com.umc.study.domain.Member;
import com.umc.study.service.MemberService.MemberCommandService;
import com.umc.study.web.dto.MemberRequest;
import com.umc.study.web.dto.MemberResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> join(@RequestBody @Valid MemberRequest.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
