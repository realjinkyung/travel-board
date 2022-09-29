package com.douzone.travel.board.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardDTO {
    private Long boardNo;
    private String boardName;
}
