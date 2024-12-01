package com.umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionResponse {
    private Long id;
    private Long storeId;
    private String missionSpec;
    private String deadline;
    private Integer reward;
    private String status; // 추가: 상태 (진행 중, 완료 등)
}
