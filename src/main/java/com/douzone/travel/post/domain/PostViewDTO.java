package com.douzone.travel.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostViewDTO {
    private Long postNo;
    private String username;
    private String title;
    private String content;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private Integer reportedNo;
    private Long views;
}
