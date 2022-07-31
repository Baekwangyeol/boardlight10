package com.boardagain.light10.repository;

import com.boardagain.light10.domain.posts.Posts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@SpringBootTest
@Transactional
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void clear() {
        postsRepository.deleteAll();
    }

    @Test
    public void createPostsAndGetPosts() {
        Posts posts = Posts.builder()
                .title("제목입니다.")
                .content("내용입니다.")
                .writer("작성자")
                .build();

        Posts save = postsRepository.save(posts);

        Optional<Posts> byId = postsRepository.findById(save.getId());

        System.out.println("byId = " + byId);

    }


}
