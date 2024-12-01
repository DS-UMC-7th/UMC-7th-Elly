package com.umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MissionRequest {
    @NotNull
    Integer reward;
    @NotNull
    LocalDate deadline;
    @NotBlank
    String missionSpec;
    @NotNull
    Long storeId;
}

