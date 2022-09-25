package domain;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CommentViewDTO {
    private Long commentNo;
    private String username;
    private Long postNo;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private String content;
}
