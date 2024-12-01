package com.umc.study.apiPayload.exception.handler;

import com.umc.study.apiPayload.code.BaseErrorCode;
import com.umc.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
