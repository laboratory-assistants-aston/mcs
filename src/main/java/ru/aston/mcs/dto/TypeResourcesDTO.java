package ru.aston.mcs.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeResourcesDTO {
    private Long nameId;
    private String name;
    private Double cost;
}
