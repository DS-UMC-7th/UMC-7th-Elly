package com.umc.study.converter;

import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.domain.Member;
import com.umc.study.web.dto.ReviewRequest;
import com.umc.study.web.dto.ReviewResponse;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    public Review toEntity(ReviewRequest dto, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .body(dto.getBody())
                .score(dto.getScore())
                .build();
    }
}
