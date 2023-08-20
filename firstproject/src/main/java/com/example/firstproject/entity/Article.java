package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity // 이걸 해줘야 DB가 해당객체를 인식가능
@AllArgsConstructor
@ToString
@NoArgsConstructor //디폴트 생성자 추가
@Getter
public class Article {
    @Id// 대표값을 지정
    @GeneratedValue //1,2,3 자동생성 어노테이션

    private Long id;
    @Column
    private String title;
    @Column
    private String content;

}
