package com.umc.study.validation.validator;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.repository.MissionRepository.MemberMissionRepository;
import com.umc.study.validation.annotation.UniqueMemberMission;
import com.umc.study.web.dto.AddMissionRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueMemberMissionValidator implements ConstraintValidator<UniqueMemberMission, AddMissionRequest> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(AddMissionRequest dto, ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) {
            return true; // NotNull 검증은 다른 곳에서 처리
        }

        boolean exists = memberMissionRepository.existsByMember_IdAndMission_IdAndStatus(
                dto.getMemberId(),
                dto.getMissionId(),
                MissionStatus.CHALLENGING
        );

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.CHALLENGING_MISSION.toString())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
