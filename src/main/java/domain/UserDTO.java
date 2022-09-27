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

    private Long userNo;		// 사용자 번호
    private String username;	// 사용자 id
    private String name;		// 사용자 이름
    private String password;	// 사용자 번호
    private String roleCode;	// 
    private int reportedNum;	//
    private boolean isBlind;	//
    private String profilePath;	//
    private String phoneNumber;	// 사용자 전화번호
    private String email;		// 사용자 email
    private Date birth;			// 사용자 생년월일
    private String gender;		// 사용자 성별

}
