package com.boardagain.light10.web.controller;

import com.boardagain.light10.service.posts.PostsService;
import com.boardagain.light10.web.dto.PostsRequestDto;
import com.boardagain.light10.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping("/posts/list")
    public String list(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "/posts/list";
    }

    @GetMapping("/posts/write")
    public String write(Model model) {
        model.addAttribute("boards", new PostsRequestDto());
        return "/posts/form";
    }

    @PostMapping("/posts/write")
    public String write(PostsRequestDto dto){
        postsService.write(dto);
        return "redirect:/posts/list";
    }

    /* 상세 보기 */
    @GetMapping("/posts/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "/posts/detail";
    }

    @GetMapping("posts/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "/posts/update";
    }

    @PutMapping("/posts/update/{id}")
    public String update(@PathVariable Long id, PostsRequestDto dto){
        if(id ==null ){
            return "/posts/list";
        }else{
            postsService.update(id,dto);
            return "redirect:/posts/detail/"+id;
        }

    }
}
