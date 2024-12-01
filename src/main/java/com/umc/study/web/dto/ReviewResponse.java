package com.umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponse {

    private Long reviewId;

    public ReviewResponse(Long reviewId) {
        this.reviewId = reviewId;
    }
}
