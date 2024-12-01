package com.umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {
    @NotBlank
    String regionName; // 지역 이름
    @NotBlank
    String storeName;  // 가게 이름
    @NotBlank
    String storeAddress; // 가게 주소
}

