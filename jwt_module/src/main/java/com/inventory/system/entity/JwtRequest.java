package com.inventory.system.entity;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
    private String userName;
    private String userPassword;
}
