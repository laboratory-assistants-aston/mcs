package ru.aston.mcs.service.fix;


import ru.aston.mcs.dto.request.RoleRequest;
import ru.aston.mcs.dto.response.RoleResponse;

import java.util.List;

public interface IRolesService {

    List<RoleResponse> getAll();

    RoleResponse get(Long id);

    RoleResponse create(RoleRequest roleRequest);

    RoleResponse update(Long id, RoleRequest roleRequest);

    void delete(Long id);
}
