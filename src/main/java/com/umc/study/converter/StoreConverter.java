package com.umc.study.converter;


import com.umc.study.domain.Region;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.web.dto.StoreRequest;
import com.umc.study.web.dto.StoreResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponse.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponse.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponse.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponse.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponse.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
