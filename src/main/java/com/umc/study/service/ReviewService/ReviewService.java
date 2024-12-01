package com.umc.study.service.ReviewService;

import com.umc.study.web.dto.ReviewRequest;
import com.umc.study.web.dto.ReviewResponse;
import org.springframework.data.domain.Page;

public interface ReviewService {
    public Long createReview(ReviewRequest dto);
}
