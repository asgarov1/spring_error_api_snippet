package com.asgarov.api.response.service;

import com.asgarov.api.response.exception.MyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private MyService myService;

    public String getArticle(String id) {
        String dummy = myService.getArticle();

        throw new MyCustomException(id);
    }

}
