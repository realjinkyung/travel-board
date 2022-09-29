package com.douzone.travel.board.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardDTO {
    private Long boardNo;		// 게시판 번호
    private String boardName;	// 게시판 이름
}
