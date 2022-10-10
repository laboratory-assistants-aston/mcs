package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
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
    public StatusDTO getStatus(Long statusId) {
        return statusMapper.toDTO(
                statusRepository.findById(statusId)
                        .orElseThrow( () -> new EntityNotFoundException(statusId)));
    }

    @Override
    public StatusDTO createStatus(StatusDTO statusDTO) {

        if (statusDTO == null ) {
            throw new InvalidRequestException();
        }

        return statusMapper.toDTO(
                statusRepository.save(
                        (statusMapper.toModel(statusDTO))));
    }

    @Override
    public StatusDTO updateStatus(Long statusId, StatusDTO statusDTO){

        if (statusDTO == null ||statusId == null) {
            throw new InvalidRequestException();
        }
        Status statusFromDb =  statusRepository.findById(statusId)
                .orElseThrow( () -> new EntityNotFoundException(statusId));

        statusFromDb.setName(statusDTO.getStatusName());

        return statusMapper.toDTO(statusRepository.save(statusFromDb));
    }

    @Override
    public void deleteStatus(Long id) {
        if (statusRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException( id );
        }
        statusRepository.deleteById(id);

    }
}
