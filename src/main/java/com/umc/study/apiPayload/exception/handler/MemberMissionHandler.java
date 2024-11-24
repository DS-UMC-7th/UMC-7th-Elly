package com.umc.study.apiPayload.exception.handler;

import com.umc.study.apiPayload.code.BaseErrorCode;
import com.umc.study.apiPayload.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {
    public MemberMissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
