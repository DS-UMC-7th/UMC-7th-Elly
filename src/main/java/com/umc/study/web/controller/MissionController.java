package com.umc.study.web.controller;

import com.umc.study.service.MissionService.MissionService;
import com.umc.study.web.dto.MissionRequest;
import com.umc.study.web.dto.MissionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<MissionResponse> createMission(@RequestBody @Valid MissionRequest dto) {
        MissionResponse missionResponse = missionService.createMission(dto);
        return ResponseEntity.ok(missionResponse);
    }
}

