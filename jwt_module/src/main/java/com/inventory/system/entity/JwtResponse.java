package com.inventory.system.entity;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private User user;
    private String jwtToken;
}
