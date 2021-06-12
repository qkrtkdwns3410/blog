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
import java.util.List;

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
    
    @ManyToOne(fetch = FetchType.EAGER) //여러 게시판에 하나의 유저네임이기에 패치를 자주합니다.
    @JoinColumn(name = "userId")
    private User user; //DB는 오브젝트를 저장할 수 없다. 하지만 FK, 자바는 오브젝트를 저장할 수 있다.
    
    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER) //DB에 컬럼을 만들지 마세요 .. 제 주인은 바로 보드입니다. //mappedBy 연관관계의 주인이 아닙니다. //기본 패치 타입이 lazy입니다 (댓글 펼치기인경우) 하지만 그냥 바로 보이는 경우에는 이거 전략을 사용합니다.
    private List<Reply> reply;
    
    
    @CreationTimestamp
    private Timestamp createDate;
}
