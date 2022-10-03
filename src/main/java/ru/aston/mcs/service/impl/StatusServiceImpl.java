package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.mapper.StatusMapper;
import ru.aston.mcs.repository.StatusRepository;
import ru.aston.mcs.service.StatusService;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusMapper statusMapper;
    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusMapper statusMapper, StatusRepository statusRepository) {
        this.statusMapper = statusMapper;
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusDTO> getAllStatus() {
        return statusMapper.toDTOList(statusRepository.findAll());
    }

    @Override
    public StatusDTO getStatus(Long id) {
        return statusMapper.toDTO(
                statusRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveStatus(StatusDTO statusDTO) {
        statusRepository.save(statusMapper.toModel(statusDTO));
    }

    @Override
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
