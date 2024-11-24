package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.service.ReviewService.ReviewService;
import com.umc.study.web.dto.ReviewRequest;
import com.umc.study.web.dto.ReviewResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponse> createReview(@Valid @RequestBody ReviewRequest dto) {
        Long reviewId = reviewService.createReview(dto);
        ReviewResponse response = new ReviewResponse(reviewId);
        return ApiResponse.onSuccess(response);
    }
}
