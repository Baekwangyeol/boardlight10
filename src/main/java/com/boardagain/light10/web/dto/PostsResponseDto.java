package com.boardagain.light10.web.dto;

import com.boardagain.light10.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdDate, modifiedDate;
    private int view;

    /*Entity -->Dto */
    public PostsResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.writer = posts.getWriter();
        this.content = posts.getContent();
        this.createdDate = posts.getCreatedDate();
        this.modifiedDate = posts.getModifiedDate();
        this.view = posts.getView();
    }
}
