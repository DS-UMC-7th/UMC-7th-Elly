package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.service.MemberMissionService.MemberMissionService;
import com.umc.study.web.dto.AddMissionRequest;
import com.umc.study.web.dto.AddMissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/member-missions")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping
    public ApiResponse<AddMissionResponse> addMemberMission(@Valid @RequestBody AddMissionRequest dto) {
        AddMissionResponse response = memberMissionService.addMemberMission(dto);
        return ApiResponse.onSuccess(response);
    }
}
