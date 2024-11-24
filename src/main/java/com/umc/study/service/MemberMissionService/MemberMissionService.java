package com.umc.study.service.MemberMissionService;

import com.umc.study.web.dto.AddMissionRequest;
import com.umc.study.web.dto.AddMissionResponse;

public interface MemberMissionService {
    public AddMissionResponse addMemberMission(AddMissionRequest dto);
}
