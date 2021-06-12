package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;
    
    @Column(nullable = false, length = 100)
    private String title;
    
    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.
    
    @ColumnDefault("'0'")
    private int count; //조회수
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; //DB는 오브젝트를 저장할 수 없다. 하지만 FK, 자바는 오브젝트를 저장할 수 있다.
    
    
    @CreationTimestamp
    private Timestamp createDate;
}
