package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;
    
    @Column(nullable = false, length = 200)
    private String content;
    
    @ManyToOne //여러개의 답변은 하나의  게시글에 올라갈수 있습니다.
    @JoinColumn(name = "boardId")
    private Board board;
    
    @ManyToOne //여러개의 답변은 하나의 유저가 작성할 수 있습니다.
    @JoinColumn(name = "userId")
    private User user;
    @CreationTimestamp
    private Timestamp createDate;
}
