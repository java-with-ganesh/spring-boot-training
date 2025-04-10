package com.i2i;


import com.i2i.exception.ExceptionAdvice;
import org.springframework.context.annotation.Import;

@Import(ExceptionAdvice.class)
public @interface ExceptionHandler {
}
