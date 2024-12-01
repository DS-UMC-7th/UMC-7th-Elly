package com.umc.study.repository.MissionRepository;

import com.umc.study.domain.Mission;
import com.umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> missionStatus(Long memberId, MissionStatus status);
    List<Mission> missionByRegion(Long regionId);
}