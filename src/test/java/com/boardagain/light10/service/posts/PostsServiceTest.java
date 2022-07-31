package com.boardagain.light10.service.posts;

import com.boardagain.light10.repository.PostsRepository;
import com.boardagain.light10.web.dto.PostsRequestDto;
import com.boardagain.light10.web.dto.PostsResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void 게시글_생성() {
        PostsRequestDto posts = PostsRequestDto.builder()
                .title("Test title")
                .writer("user")
                .content("Test Content")
                .view(0)
                .build();

        Long post1 = postsService.write(posts);

        List<PostsResponseDto> read = postsService.read(post1);

        assertThat(read.size()).isEqualTo(1);
        System.out.println("read.get(0).getTitle() = " + read.get(0).getTitle());

    }

}