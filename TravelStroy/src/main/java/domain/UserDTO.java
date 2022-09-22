package domain;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {
    private Long userNo;
    private String username;  // user id
    private String password;
    private String roleCode;
    private int reportedNum;
    private boolean isBlind;
    private String profilePath;
    private String phoneNumber;
    private String email;
    private Date birth;
    private String gender;

}
