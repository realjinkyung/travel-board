package domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostDTO {
    private Long postNo;
    private Long userNo;
    private Long boardNo;
    private String title;
    private String content;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private Integer reportedNo;
    private Integer favoriteNo;
}
