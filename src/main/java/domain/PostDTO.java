package domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostDTO {		// 게시물 작성 DTO
    private Long postNo;	// 게시물 번호
    private Long userNo;	// 사용자 번호
    private Long boardNo;	// 게시판 번호 - 게시판 DTO
    private String title;	// 제목
    private String content;	// 내용
    private Date createdAt;	// 작성일자
    private Date modifiedAt;// 수정일자
    private Date deletedAt;	// 삭제일자
    private Long views;		// 조회수
}
