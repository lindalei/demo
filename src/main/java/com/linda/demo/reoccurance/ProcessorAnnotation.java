package com.linda.demo.reoccurance;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(IndexPostProcessor.class)
public @interface ProcessorAnnotation {
}
