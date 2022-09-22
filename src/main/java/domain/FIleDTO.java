package domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FIleDTO {

    Long fileNo;
    Long postNo;
    String filePath;

}
