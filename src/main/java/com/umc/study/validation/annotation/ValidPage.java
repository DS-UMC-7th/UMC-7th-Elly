package com.umc.study.validation.annotation;

import com.umc.study.validation.validator.PageValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PageValidator.class)
@Documented
public @interface ValidPage {

    String message() default "페이지 번호는 1 이상의 값이어야 합니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}