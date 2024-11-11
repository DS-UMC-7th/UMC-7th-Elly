package com.umc.study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.study.domain.Mission;
import com.umc.study.domain.QStore;
import com.umc.study.domain.QRegion;
import com.umc.study.domain.QMission;
import com.umc.study.domain.mapping.QMemberMission;
import com.umc.study.domain.enums.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QMission mission = QMission.mission;

    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QStore store = QStore.store;
    private final QRegion region = QRegion.region;

    @Override
    public List<Mission> missionStatus(Long memberId, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (status != null && status == MissionStatus.CHALLENGING) {
            predicate.and(memberMission.status.eq(MissionStatus.CHALLENGING));
        } else if (status != null && status == MissionStatus.COMPLETE) {
            predicate.and(memberMission.status.eq(MissionStatus.COMPLETE));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission, memberMission.mission)
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Mission> missionByRegion(Long regionId) {
        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)    // Join Mission to Store
                .join(store.region, region)    // Join Store to Region
                .where(regionIdEq(regionId))   // Filter by region ID
                .fetch();
    }

    private BooleanExpression regionIdEq(Long regionId) {
        if (regionId == null) {
            return null;
        }
        return region.id.eq(regionId);
    }
}

