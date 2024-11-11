package com.umc.study.repository.ReviewRepository;

import com.umc.study.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByStoreId(Long storeId);
}
