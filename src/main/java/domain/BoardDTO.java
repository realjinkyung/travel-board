package domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardDTO {
    private Long boardNo;		// 게시글 번호
    private String boardName;	// 게시글
}
