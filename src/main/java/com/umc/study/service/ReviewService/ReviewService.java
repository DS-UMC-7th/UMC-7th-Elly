package com.umc.study.service.ReviewService;

import com.umc.study.web.dto.ReviewRequest;

public interface ReviewService {
    public Long createReview(ReviewRequest dto);
}
