package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.CommentRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        // 서비스에 위임
        List<CommentDto> dtos = commentService.comments(articleId);
        // 결과 응답

        return ResponseEntity.status(HttpStatus.OK).body(dtos);}

    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto) {
        //서비스 위임
        commentService.create(articleId, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> update(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto) {
        //서비스 위임
        commentService.update(articleId, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
