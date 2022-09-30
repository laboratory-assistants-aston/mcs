package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeResourcesDTO {
    private Long nameId;
    private String name;
    private Double cost;
}
