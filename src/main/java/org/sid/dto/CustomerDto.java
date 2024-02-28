package org.sid.dto;


import lombok.*;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
}
