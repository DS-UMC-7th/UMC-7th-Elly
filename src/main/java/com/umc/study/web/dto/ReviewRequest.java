package com.umc.study.web.dto;

import com.umc.study.validation.annotation.ValidStoreId;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {

    @NotNull
    private Long memberId;

    @NotNull
    @ValidStoreId
    private Long storeId;

    @Size(min = 10, max = 1000)
    private String body;

    @NotNull
    private Float score;
}
