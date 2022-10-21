package ru.aston.mcs.service.fix;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.RoleRequest;
import ru.aston.mcs.dto.response.RoleResponse;
import ru.aston.mcs.entity.Role;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewRoleMapper;
import ru.aston.mcs.repository.RolesRepository;

import java.util.List;

@Service
@Transactional
public class NewRolesServiceImpl implements IRolesService{

    private final RolesRepository rolesRepository;

    private final NewRoleMapper newRoleMapper;

    public NewRolesServiceImpl(RolesRepository rolesRepository, NewRoleMapper newRoleMapper) {
        this.rolesRepository = rolesRepository;
        this.newRoleMapper = newRoleMapper;
    }

    @Override
    public List<RoleResponse> getAll() {
      return  newRoleMapper.toResponseList(rolesRepository.findAll());
    }

    @Override
    public RoleResponse get(Long id) {
        return newRoleMapper.toResponse(
                rolesRepository.findById(id)
                        .orElseThrow(RuntimeException::new));    }

    @Override
    public RoleResponse create(RoleRequest roleRequest) {
        if (roleRequest == null) {
            throw new InvalidRequestException();
        }
        return newRoleMapper.toResponse(
                rolesRepository.save(
                        newRoleMapper.toEntity(roleRequest)));
    }

    @Override
    public RoleResponse update(Long id, RoleRequest roleRequest) {
        if (roleRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        Role roleFromDb =
                rolesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        roleFromDb.setRoleName(roleRequest.getRoleName());

        return newRoleMapper.toResponse(rolesRepository.save(roleFromDb));
    }

    @Override
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }
}
