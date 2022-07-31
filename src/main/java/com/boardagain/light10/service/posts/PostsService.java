package com.boardagain.light10.service.posts;

import com.boardagain.light10.domain.posts.Posts;
import com.boardagain.light10.repository.PostsRepository;
import com.boardagain.light10.web.dto.PostsRequestDto;
import com.boardagain.light10.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    /*create */
    @Transactional
    public Long write(PostsRequestDto dto){
        Posts posts = dto.toEntity();
        postsRepository.save(posts);
        return posts.getId();
    }

    /* 게시글 리스트 조회 readOnly 속성으로 조회속도 개선*/
    @Transactional(readOnly = true)
    public List<PostsResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsResponseDto::new)
                .collect(Collectors.toList());
    }

    /* Read 하나 상세*/
    @Transactional(readOnly = true)
    public List<PostsResponseDto> read(Long id) {
        return postsRepository.findById(id).stream()
                .map(PostsResponseDto::new)
                .collect(Collectors.toList());
    }


}
