package org.galapagos.mcmorning.vo;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Member implements Serializable {
    private String userId;
    private String pwd;
    private String name;
    private String email;


}
