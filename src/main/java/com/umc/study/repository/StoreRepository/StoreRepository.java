package com.umc.study.repository.StoreRepository;

import com.umc.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}