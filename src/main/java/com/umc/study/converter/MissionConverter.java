package com.umc.study.converter;

import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.web.dto.MissionRequest;
import com.umc.study.web.dto.MissionResponse;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public Mission toEntity(MissionRequest dto, Store store) {
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public MissionResponse toDto(Mission mission) {
        MissionResponse responseDto = new MissionResponse();
        responseDto.setId(mission.getId());
        responseDto.setReward(mission.getReward());
        responseDto.setDeadline(mission.getDeadline());
        responseDto.setMissionSpec(mission.getMissionSpec());
        responseDto.setStoreId(mission.getStore().getId());
        return responseDto;
    }
}

