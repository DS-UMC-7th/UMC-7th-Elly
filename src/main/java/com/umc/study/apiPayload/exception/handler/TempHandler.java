package com.umc.study.apiPayload.exception.handler;

import com.umc.study.apiPayload.code.BaseErrorCode;
import com.umc.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}