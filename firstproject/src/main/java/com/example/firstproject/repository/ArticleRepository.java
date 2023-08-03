package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> { //확장을 통해 crud에 필요한 save같은 기본함수 사용가능

}
