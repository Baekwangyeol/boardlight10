package com.boardagain.light10.repository;

import com.boardagain.light10.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();

    @Modifying
    @Query(value ="update Posts p set p.view = p.view + 1 where p.id = :id")
    int updateView(@Param("id") Long id);
}
