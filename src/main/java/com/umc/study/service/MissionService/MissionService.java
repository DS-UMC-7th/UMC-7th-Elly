package com.umc.study.service.MissionService;

import com.umc.study.web.dto.MissionRequest;
import com.umc.study.web.dto.MissionResponse;
import org.springframework.data.domain.Page;

public interface MissionService {
    MissionResponse createMission(MissionRequest dto);
    public Page<MissionResponse> getMissionsByStore(Long storeId, int page);
    public Page<MissionResponse> getMyMissions(Long memberId, int page);
}
