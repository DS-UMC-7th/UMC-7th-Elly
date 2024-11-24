package com.umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MissionRequest {
    @NotBlank
    Integer reward;
    @NotBlank
    LocalDate deadline;
    @NotBlank
    String missionSpec;
    @NotBlank
    Long storeId;
}

