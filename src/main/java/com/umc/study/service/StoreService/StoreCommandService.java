package com.umc.study.service.StoreService;

import com.umc.study.web.dto.StoreRequest;
import com.umc.study.web.dto.StoreResponse;

public interface StoreCommandService {
    StoreResponse addStoreToRegion(StoreRequest storeRequest);
}
