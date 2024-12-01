package com.umc.study.converter;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.domain.mapping.MemberMission;
import com.umc.study.web.dto.AddMissionResponse;
import org.springframework.stereotype.Component;

@Component
public class AddMissionConverter {

    public MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();
    }

    public AddMissionResponse toDto(MemberMission memberMission) {
        AddMissionResponse responseDto = new AddMissionResponse();
        responseDto.setId(memberMission.getId());
        responseDto.setMemberId(memberMission.getMember().getId());
        responseDto.setMissionId(memberMission.getMission().getId());
        responseDto.setStatus(memberMission.getStatus().name());
        return responseDto;
    }
}
