package com.umc.study.service.MissionService;

import com.umc.study.converter.MissionConverter;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.repository.MissionRepository.MissionRepository;
import com.umc.study.repository.StoreRepository.StoreRepository;
import com.umc.study.web.dto.MissionRequest;
import com.umc.study.web.dto.MissionResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MissionConverter missionConverter;

    @Override
    @Transactional
    public MissionResponse createMission(MissionRequest dto) {
        // Validate and fetch store
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + dto.getStoreId()));

        // Convert DTO to entity
        Mission mission = missionConverter.toEntity(dto, store);

        // Save mission
        Mission savedMission = missionRepository.save(mission);

        // Convert saved entity to response DTO
        return missionConverter.toDto(savedMission);
    }
}
