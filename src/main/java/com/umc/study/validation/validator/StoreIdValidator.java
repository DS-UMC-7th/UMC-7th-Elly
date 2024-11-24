package com.umc.study.validation.validator;

import com.umc.study.repository.StoreRepository.StoreRepository;
import com.umc.study.validation.annotation.ValidStoreId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StoreIdValidator implements ConstraintValidator<ValidStoreId, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return storeRepository.existsById(value);
    }
}
