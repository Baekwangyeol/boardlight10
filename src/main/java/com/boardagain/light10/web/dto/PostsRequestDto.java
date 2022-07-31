package com.boardagain.light10.web.dto;

import com.boardagain.light10.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsRequestDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdDate, modifiedDate;
    private int view;

    /*Dto ->Entity */
    public Posts toEntity() {
        Posts posts =Posts.builder()
                    .id(id)
                    .title(title)
                    .writer(writer)
                    .content(content)
                    .view(0)
                    .build();

                return posts;
    }

}
