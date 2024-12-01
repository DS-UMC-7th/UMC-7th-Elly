package com.umc.study.web.dto;

import lombok.Data;

@Data
public class AddMissionResponse {
    private Long id;
    private Long memberId;
    private Long missionId;
    private String status;
}