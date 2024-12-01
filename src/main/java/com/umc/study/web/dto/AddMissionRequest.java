package com.umc.study.web.dto;

import com.umc.study.validation.annotation.UniqueMemberMission;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@UniqueMemberMission
public class AddMissionRequest {

    @NotNull(message = "Member ID cannot be null.")
    private Long memberId;

    @NotNull(message = "Mission ID cannot be null.")
    private Long missionId;
}
