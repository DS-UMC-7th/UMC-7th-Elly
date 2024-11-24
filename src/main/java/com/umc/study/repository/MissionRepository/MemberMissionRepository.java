package com.umc.study.repository.MissionRepository;

import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMember_IdAndMission_IdAndStatus(Long memberId, Long missionId, MissionStatus status);
}

