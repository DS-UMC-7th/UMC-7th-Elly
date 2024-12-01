package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.service.ReviewService.ReviewService;
import com.umc.study.web.dto.ReviewRequest;
import com.umc.study.web.dto.ReviewResponse;
import com.umc.study.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Tag(name = "Review API", description = "리뷰 관련 API")
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "리뷰 작성", description = "새로운 리뷰를 작성합니다.")
    @PostMapping
    public ApiResponse<ReviewResponse> createReview(@Valid @RequestBody ReviewRequest dto) {
        Long reviewId = reviewService.createReview(dto);
        ReviewResponse response = new ReviewResponse(reviewId);
        return ApiResponse.onSuccess(response);
    }
}