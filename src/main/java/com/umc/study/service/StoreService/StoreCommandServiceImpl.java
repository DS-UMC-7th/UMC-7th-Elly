package com.umc.study.service.StoreService;

import com.umc.study.converter.StoreConverter;
import com.umc.study.domain.Region;
import com.umc.study.domain.Store;
import com.umc.study.repository.RegionRepository.RegionRepository;
import com.umc.study.repository.StoreRepository.StoreRepository;
import com.umc.study.web.dto.StoreRequest;
import com.umc.study.web.dto.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreResponse addStoreToRegion(StoreRequest storeRequest) {
        // 1. Region 조회
        Region region = regionRepository.findByName(storeRequest.getRegionName())
                .orElseThrow(() -> new IllegalArgumentException("Region not found: " + storeRequest.getRegionName()));

        // 2. StoreRequest -> Store 변환
        Store store = StoreConverter.toStore(storeRequest, region);

        // 3. Store 저장
        Store savedStore = storeRepository.save(store);

        // 4. Store -> StoreResponse 변환 후 반환
        return StoreConverter.toStoreResponse(savedStore);
    }
}
