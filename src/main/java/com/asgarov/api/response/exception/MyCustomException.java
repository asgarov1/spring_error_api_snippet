package com.asgarov.api.response.exception;

public class MyCustomException extends RuntimeException {

    private final String articleId;

    public MyCustomException(String articleId) {
        this.articleId = articleId;
    }

    public MyCustomException(String message, String articleId) {
        super(message);
        this.articleId = articleId;
    }

    public String getArticleId() {
        return articleId;
    }
}
