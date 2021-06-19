package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity//User 클래스가 MySql에 테이블이 생성이 된다.
//@DynamicInsert //무조건 어노테이션을 무한대로 붙이는 방법은 비추된다. //inset시 null을 제외해 주는 기능을 가지고 있습니다.
public class User {
    
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; //시퀀스 ,  auto_increment
    
    @Column(nullable = false, length = 30, unique = true) //유니크는 중복을 없애주는 역할을 합니다.
    private String username;
    
    @Column(nullable = false, length = 100) //123456 >> 해쉬(비밀번호 암호화)
    private String password;
    
    @Column(nullable = false, length = 50,unique = true)
    private String email;
    
    //    @ColumnDefault("user")
    @Enumerated(EnumType.STRING) //해당 roletype이 string이라는 것을 가르쳐 줘야합니다.
    private RoleType role; //Enum을 쓰는게 좋습니다. // Admin, user  //실수로 데이터베이스에 오타가 들어갈수도 있음 >> enum은 셋중에 하나가 들어가도록 유도할 수 있습니다.
    
    @CreationTimestamp //시간이 자동으로 입력됩니다.
    private Timestamp createDate;
    
    
}
