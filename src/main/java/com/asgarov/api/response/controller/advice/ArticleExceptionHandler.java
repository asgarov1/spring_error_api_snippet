package com.asgarov.api.response.controller.advice;

import com.asgarov.api.response.exception.MyCustomException;
import com.asgarov.api.response.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArticleExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<ErrorResponse> onMyCustomException(MyCustomException e) {
        String message = String.format("No article with id %s found", e.getArticleId());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("ARTICLE_NOT_FOUND", message));
    }
}
