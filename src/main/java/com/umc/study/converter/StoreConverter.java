package com.umc.study.converter;


import com.umc.study.domain.Region;
import com.umc.study.domain.Store;
import com.umc.study.web.dto.StoreRequest;
import com.umc.study.web.dto.StoreResponse;

public class StoreConverter {

    // StoreRequest -> Store 변환
    public static Store toStore(StoreRequest request, Region region) {
        return Store.builder()
                .name(request.getStoreName())
                .address(request.getStoreAddress())
                .region(region) // 연관된 Region 설정
                .build();
    }

    // Store -> StoreResponse 변환
    public static StoreResponse toStoreResponse(Store store) {
        return StoreResponse.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionName(store.getRegion() != null ? store.getRegion().getName() : "N/A")
                .createdAt(store.getCreatedAt())
                .build();
    }
}
