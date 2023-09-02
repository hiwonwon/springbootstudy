package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity // 이걸 해줘야 DB가 해당객체를 인식가능 (해당 클래스로 테이블을 만든다.)
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자 추가
@ToString
@Getter
public class Article {


    @Id// 대표값을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 id를  자동 생성 어노테이션
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public void patch(Article article){
        if(article.title!=null)
            this.title=article.title;
        if(article.content!=null)
            this.content=article.content;
    }

}
