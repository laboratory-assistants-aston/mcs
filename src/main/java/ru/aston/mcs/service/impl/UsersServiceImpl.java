package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.UsersDTO;
import ru.aston.mcs.mapper.UsersMapper;
import ru.aston.mcs.repository.UsersRepository;
import ru.aston.mcs.service.UsersService;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    @Override
    public List<UsersDTO> getAllUser() {
        return usersMapper.toDTOList(usersRepository.findAll());
    }

    @Override
    public UsersDTO getUser(Long id) {
        return usersMapper.toDTO(usersRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void createUser(UsersDTO userDto) {
        usersRepository.save(usersMapper.toModel(userDto));
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
