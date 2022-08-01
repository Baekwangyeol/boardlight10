package com.boardagain.light10.domain.posts;

import com.boardagain.light10.domain.TimeEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Posts extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable= false)
    private String content;

    private String writer;

    @Column(columnDefinition = "integer default 0")
    private int view;

    public void update(String title, String content){
        this.title= title;
        this.content = content;
    }

}
