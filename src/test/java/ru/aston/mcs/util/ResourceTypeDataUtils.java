package ru.aston.mcs.util;

import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.entity.ResourceType;

import java.util.List;

public class ResourceTypeDataUtils {
    public static ResourceTypeDTO createResourceTypeDTO() {
        return new ResourceTypeDTO(1L, "parking",100.00);
    }

    public static ResourceType createResourceTypeEntity() {
        return new ResourceType(3L, "parking",100.00);
    }

    public static List<ResourceType> createResourceTypeEntityList() {
        return  List.of(new ResourceType(1L, "parking",100.00), new ResourceType(2L, "co-working",50.00));
    }
    public static List<ResourceTypeDTO> createResourceTypeDTOList() {
        return  List.of(new ResourceTypeDTO(1L, "parking",100.00), new ResourceTypeDTO(2L, "co-working",50.00));
    }
}
