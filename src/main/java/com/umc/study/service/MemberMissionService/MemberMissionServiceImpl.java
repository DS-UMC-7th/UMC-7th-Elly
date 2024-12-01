package com.umc.study.service.MemberMissionService;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.apiPayload.exception.handler.MemberMissionHandler;
import com.umc.study.converter.AddMissionConverter;
import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.domain.mapping.MemberMission;
import com.umc.study.repository.MemberRepository.MemberRepository;
import com.umc.study.repository.MissionRepository.MemberMissionRepository;
import com.umc.study.repository.MissionRepository.MissionRepository;
import com.umc.study.web.dto.AddMissionRequest;
import com.umc.study.web.dto.AddMissionResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final AddMissionConverter memberMissionConverter;

    @Override
    @Transactional
    public AddMissionResponse addMemberMission(AddMissionRequest request) {
        // 중복 미션 검증: Member와 Mission의 상태 확인
        boolean isChallenging = memberMissionRepository.existsByMember_IdAndMission_IdAndStatus(
                request.getMemberId(),
                request.getMissionId(),
                MissionStatus.CHALLENGING
        );

// 추가된 로깅
        System.out.println("DEBUG: isChallenging = " + isChallenging);

        if (isChallenging) {
            System.out.println("DEBUG: CHALLENGING_MISSION condition met for memberId="
                    + request.getMemberId() + ", missionId=" + request.getMissionId());
            throw new MemberMissionHandler(ErrorStatus.CHALLENGING_MISSION);
        } else {
            System.out.println("DEBUG: No CHALLENGING_MISSION found for memberId="
                    + request.getMemberId() + ", missionId=" + request.getMissionId());
        }

        // Member 조회
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + request.getMemberId()));

        // Mission 조회
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found with ID: " + request.getMissionId()));

        // MemberMission 생성
        MemberMission memberMission = memberMissionConverter.toEntity(member, mission);

        // MemberMission 저장
        MemberMission savedMemberMission = memberMissionRepository.save(memberMission);

        // 응답 DTO 반환
        return memberMissionConverter.toDto(savedMemberMission);
    }
}