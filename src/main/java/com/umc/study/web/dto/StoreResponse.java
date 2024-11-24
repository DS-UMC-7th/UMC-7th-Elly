package com.umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class StoreResponse {
    Long id;
    String name;
    String address;
    String regionName;
    LocalDateTime createdAt;
}

