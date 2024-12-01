package com.umc.study.repository.MissionRepository;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findByStore(Store store, Pageable pageable);
    @Query("SELECT m FROM Mission m JOIN MemberMission mm ON mm.mission.id = m.id " +
            "WHERE mm.member.id = :memberId")
    Page<Mission> findMissionsByMemberId(@Param("memberId") Long memberId, Pageable pageable);
}
