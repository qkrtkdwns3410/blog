package com.cos.blog.service;


import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줍니다. 즉 IOC를 해준다.
@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    
    @Transactional
    public void 글쓰기(Board board, User user) { //title,content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }
    
    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable) {
        return boardRepository.findAll(pageable); //페이징이 되어 리턴을 합니다.
    }
    
    @Transactional(readOnly = true)
    public Board 글상세보기(int id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }
    
    @Transactional
    public void 글삭제하기(int id, PrincipalDetail principal) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 찾기 실패 : 해당 글이 존재하지 않습니다.");
        });
        if (board.getUser().getId() != principal.getUser().getId()) {
            throw new IllegalArgumentException("글 삭제 실패 : 해당 글을 삭제할 권한이 없습니다.");
        }
        boardRepository.delete(board);
    }
    
    @Transactional
    public void 글수정하기(int id, Board requestBoard) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 찾기 실패 : 아이디가 존재하지 않습니다.");
        }); //영속화 완료
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        //해당 함수로 종료시에 (Service가 종료될 때) 트랜젝션이 종료됩니다.
        //이때 더티체킹이 이루어집니다, _>자동업데이트 (db flush)
    }
}

    
