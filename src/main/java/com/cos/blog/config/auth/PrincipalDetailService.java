package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    //스프링이 로그인 요청을 가로채서 username ,password ,변수 steal
    //password 부분을 자동처리
    //username이 DB에 있는지만 확인해주면됩니다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.:" + username);
                });
        return new PrincipalDetail(principal); //시큐리티 세션에 유저 정보가 저장됩니다.
    }
}
