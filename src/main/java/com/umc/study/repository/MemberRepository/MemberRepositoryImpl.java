package com.umc.study.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.study.domain.Member;
import com.umc.study.domain.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public List<Member> mypage(Long id){
        BooleanBuilder predicate = new BooleanBuilder();

        if (id != null) {
            predicate.and(member.id.eq(id));
        }

        return jpaQueryFactory
                .selectFrom(member)
                .where(predicate)
                .fetch();

    }
}
