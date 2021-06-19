package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


//스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
//스프링 시큐리티의 고유한 세션 저장소에 저장해 준다.
@Getter
public class PrincipalDetail implements UserDetails {
    
    private User user; //모델이 들고있는 User객 >>기본정보 (Composition)
    
    public PrincipalDetail(User user) {
        this.user = user;
    }
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    
    //계정의 만료 여부 파악 (true :만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    //계정의 락 여부 파악 (true :잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    
    //비밀번호가 만료되었는지 리턴한다(true: 만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    //계정이 활성화(사용가능)인지 리턴한다. (true:활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    //계정의 권한을 리턴합니다. (권한이 여러개 있을 수 있어서 루프를
    //돌아야하지만 우리는 한 개의 권한만 줄 예정이기에 )..
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "ROLE_" + user.getRole();
        });//어차피 GrantedAuthority는 하나의 권한만을 가진다,.
        //그래서 람다식으로 돌림.
        return collectors;
    }
    
    
}
