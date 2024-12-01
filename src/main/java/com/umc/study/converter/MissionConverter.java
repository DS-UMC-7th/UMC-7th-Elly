package com.umc.study.converter;

import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.domain.mapping.MemberMission;
import com.umc.study.web.dto.MissionRequest;
import com.umc.study.web.dto.MissionResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class MissionConverter {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Mission toEntity(MissionRequest dto, Store store) {
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline()) // Assuming it's already LocalDate
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public MissionResponse toDto(Mission mission) {
        return MissionResponse.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline().format(DATE_FORMATTER)) // Convert LocalDate to String
                .missionSpec(mission.getMissionSpec())
                .storeId(mission.getStore().getId())
                .build();
    }
}