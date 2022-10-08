package ru.aston.mcs.service.Impl;

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
    public StatusDTO getStatus(Long id) {
        return statusMapper.toDTO(
                statusRepository.findById(id)
                        .orElseThrow( () -> new EntityNotFoundException(id)));
    }

    @Override
    public void saveStatus(StatusDTO statusDTO) {

/*        if (statusDTO == null || statusDTO.getStatusId() == null) {
            throw new InvalidRequestException();
        }*/

        statusRepository.save(statusMapper.toModel(statusDTO));
    }

    @Override
    public StatusDTO updateStatus(StatusDTO statusDTO){

        if (statusDTO == null || statusDTO.getStatusId() == null) {
            throw new InvalidRequestException();
        }
        Long statusId = statusDTO.getStatusId();
        Status statusFromDb =  statusRepository.findById(statusId)
                .orElseThrow( () -> new EntityNotFoundException(statusId));

        statusFromDb.setName(statusDTO.getName());

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
