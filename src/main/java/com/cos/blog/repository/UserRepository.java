package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
//로그인을 위한 함수 만들기

//JAP Naming 쿼리 전략
//SELECT *FROM user WHERE username=?1 AND password=?2
//    User findByUsernameAndPassword(String username, String password);
//자동으로
