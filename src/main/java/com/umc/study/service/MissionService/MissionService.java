package com.umc.study.service.MissionService;

import com.umc.study.web.dto.MissionRequest;
import com.umc.study.web.dto.MissionResponse;

public interface MissionService {
    MissionResponse createMission(MissionRequest dto);
}
