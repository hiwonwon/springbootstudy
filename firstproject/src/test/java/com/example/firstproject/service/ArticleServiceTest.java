package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest//해당 클래스는 스프링부트와 연동되어 테스팅됨
class ArticleServiceTest {

    @Autowired ArticleService articleService;
    @Test
    void index() {

        //예상
        Article a = new Article(1L,"aaa","1111");
        Article b = new Article(2L,"bbb","2222");
        Article c = new Article(3L,"cccc","3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
        //실제
        List<Article> articles = articleService.index();

        //비교

        assertEquals(expected.toString(),articles.toString());
    }

    @Test
    void show_성공__존재하는_id입력() {
        //예상
        Long id = 1L;
        Article expected = new Article(id,"aaa","1111");
        //실제

        Article article=articleService.show(id);

        //비교

        assertEquals(expected.toString(),article.toString());

    }
    @Test
    void show_실패____존재하지_않는_id_입력() {

        //예상
        Long id = -1L;
        Article expected = null;
        //실제

        Article article=articleService.show(id);

        //비교

        assertEquals(expected,article);


    }

    @Test
    @Transactional  //롤백될 수있게함
    void create_성공____title과_content만_있는_dto_입력() {
        //예상
        String title = "ddddd";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(4L,title,content);

        //실제

        Article article=articleService.create(dto);

        //비교

        assertEquals(expected.toString(),article.toString());

    }
    @Test
    @Transactional
    void create_실패_____id가_포함된_dto가_들어간_경우() {
        //예상
        String title = "ddddd";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L,title,content);
        Article expected = null;

        //실제

        Article article=articleService.create(dto);

        //비교

        assertEquals(expected,article);

    }

    @Test
    @Transactional
    void update_성공_____존재하는_id_와_title_content가_있는_dto입력() {
        //예상
        Long id = 1L;
        String title = "ddddd";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = new Article(id,title,content);

        //실제

        Article article=articleService.update(1L,dto);

        //비교

        assertEquals(expected.toString(),article.toString());

    }
    @Test
    @Transactional
    void update_성공_____존재하는_id_와_title만_있는_dto입력() {
        //예상
        Long id = 1L;
        String title = "ddddd";
        ArticleForm dto = new ArticleForm(id,title,null);
        Article expected = new Article(id,title,"1111");

        //실제

        Article article=articleService.update(1L,dto);

        //비교

        assertEquals(expected.toString(),article.toString());

    }
    @Test
    @Transactional
    void update_실패_____존재하지않는_id의_dto입력() {

        //예상
        Long id = 4L;
        String title = "ddddd";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = null;

        //실제

        Article article=articleService.update(4L,dto);

        //비교

        assertEquals(expected,article);

    }
    @Test
    @Transactional
    void update_실패_____id만_있는_dto입력() {
        //예상
        Long id = 1L;
        ArticleForm dto = new ArticleForm(id,null,null);
        Article expected = null;

        //실제

        Article article=articleService.update(1L,dto);

        //비교

        assertEquals(expected,article);

    }

    @Test
    @Transactional
    void delete_성공___존재하는_id입력() {
        //예상
        Long id = 1L;
        String title = "aaa";
        String content = "1111";

        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = new Article(id,title,content);

        //실제

        Article article=articleService.update(1L,dto);

        //비교

        assertEquals(expected.toString(),article.toString());

    }
    @Test
    @Transactional
    void delete_실패___존재하지_않는_id입력() {
        //예상
        Long id = 4L;
        String title = "aaa";
        String content = "1111";

        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = null;

        //실제
        Article article=articleService.update(4L,dto);

        //비교
        assertEquals(expected,article);
    }
}
