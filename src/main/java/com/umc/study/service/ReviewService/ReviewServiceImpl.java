package com.umc.study.service.ReviewService;

import com.umc.study.converter.ReviewConverter;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.domain.Member;
import com.umc.study.repository.MemberRepository.MemberRepository;
import com.umc.study.repository.ReviewRepository.ReviewRepository;
import com.umc.study.repository.StoreRepository.StoreRepository;
import com.umc.study.web.dto.ReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewConverter reviewConverter;

    @Transactional
    public Long createReview(ReviewRequest dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Review review = reviewConverter.toEntity(dto, member, store);
        Review savedReview = reviewRepository.save(review);
        return savedReview.getId();
    }
}
