package com.umc.study.repository.RegionRepository;

import com.umc.study.domain.Region;

import java.util.Optional;

public interface RegionRepositoryCustom {
    Optional<Region> findByName(String name);
}
