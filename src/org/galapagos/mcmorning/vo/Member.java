package org.galapagos.mcmorning.vo;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Member {
    private String userId;
    private String pwd;
    private String name;
    private String email;


}
