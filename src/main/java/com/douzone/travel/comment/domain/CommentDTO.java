package com.douzone.travel.comment.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CommentDTO {
    private Long commentsNo;
    private Long userNo;
    private Long postNo;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private String content;
}
