package com.boardagain.light10.web.controller;


import com.boardagain.light10.service.posts.PostsService;
import com.boardagain.light10.web.dto.PostsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService postsService;

    /*Create*/
    public ResponseEntity<Long> write(@RequestBody PostsRequestDto dto){
        Long id = postsService.write(dto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
