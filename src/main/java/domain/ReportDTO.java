package domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReportDTO {
    private Long reportNo;
    private Long userNo;
    private Long reportedUserNo;
    private Long postNo;
    private Long commentNo;
    private String reason;
}
