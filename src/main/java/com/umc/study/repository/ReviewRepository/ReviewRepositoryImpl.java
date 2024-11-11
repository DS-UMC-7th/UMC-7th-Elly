package com.umc.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.study.domain.Review;
import com.umc.study.domain.QReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QReview review = QReview.review;

    @Override
    public List<Review> findReviewsByStoreId(Long storeId) {
        return jpaQueryFactory
                .selectFrom(review)
                .where(review.store.id.eq(storeId))
                .fetch();
    }
}