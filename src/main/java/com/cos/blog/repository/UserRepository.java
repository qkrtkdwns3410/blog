package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //select * FROM user WHERE username =1?
    Optional<User> findByUsername(String username);
}
//로그인을 위한 함수 만들기

//JAP Naming 쿼리 전략
//SELECT *FROM user WHERE username=?1 AND password=?2
//    User findByUsernameAndPassword(String username, String password);
//자동으로
