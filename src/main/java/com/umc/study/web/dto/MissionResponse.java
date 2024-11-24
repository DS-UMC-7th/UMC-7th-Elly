package com.umc.study.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MissionResponse {
    Long id;
    Integer reward;
    LocalDate deadline;
    String missionSpec;
    Long storeId;
}