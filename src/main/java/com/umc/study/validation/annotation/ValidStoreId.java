package com.umc.study.validation.annotation;

import com.umc.study.validation.validator.StoreIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StoreIdValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStoreId {
    String message() default "Invalid store ID.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
