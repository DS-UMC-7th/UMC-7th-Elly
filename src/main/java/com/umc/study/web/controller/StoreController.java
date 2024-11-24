package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.service.StoreService.StoreCommandService;
import com.umc.study.web.dto.StoreRequest;
import com.umc.study.web.dto.StoreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/add")
    public ApiResponse<StoreResponse> addStore(@RequestBody @Valid StoreRequest storeRequest) {
        StoreResponse storeResponse = storeCommandService.addStoreToRegion(storeRequest);
        return ApiResponse.onSuccess(storeResponse);
    }
}
