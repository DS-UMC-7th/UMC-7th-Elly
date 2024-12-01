package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.service.MissionService.MissionService;
import com.umc.study.web.dto.MissionRequest;
import com.umc.study.web.dto.MissionResponse;
import com.umc.study.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Tag(name = "Mission API", description = "미션 관련 API")
public class MissionController {

    private final MissionService missionService;

    @Operation(summary = "미션 생성", description = "새로운 미션을 생성합니다.")
    @PostMapping
    public ApiResponse<MissionResponse> createMission(@RequestBody @Valid MissionRequest dto) {
        MissionResponse missionResponse = missionService.createMission(dto);
        return ApiResponse.onSuccess(missionResponse);
    }

    @Operation(summary = "특정 가게의 미션 목록 조회", description = "특정 가게의 미션 목록을 페이징 처리하여 조회합니다.")
    @GetMapping("/{storeId}")
    public ApiResponse<Page<MissionResponse>> getMissionsByStore(
            @Parameter(description = "가게 ID") @PathVariable Long storeId,
            @Parameter(description = "페이지 번호 (1부터 시작)") @ValidPage @RequestParam int page) {
        Page<MissionResponse> missions = missionService.getMissionsByStore(storeId, page);
        return ApiResponse.onSuccess(missions);
    }

    @Operation(summary = "내가 진행 중인 미션 조회", description = "내가 진행 중인 미션 목록을 페이징 처리하여 조회합니다.")
    @GetMapping("/my-missions")
    public ApiResponse<Page<MissionResponse>> getMyMissions(
            @RequestParam @Valid Long memberId,
            @RequestParam @ValidPage int page) {
        Page<MissionResponse> missions = missionService.getMyMissions(memberId, page);
        return ApiResponse.onSuccess(missions);
    }
}
