package ru.aston.mcs.service.fix;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.StatusRequest;
import ru.aston.mcs.dto.response.StatusResponse;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewStatusMapper;
import ru.aston.mcs.repository.StatusRepository;

import java.util.List;

@Service
@Transactional
public class NewStatusServiceImpl implements IStatusService{

    private final StatusRepository statusRepository;

    private final NewStatusMapper newStatusMapper;

    public NewStatusServiceImpl(StatusRepository statusRepository, NewStatusMapper newStatusMapper) {
        this.statusRepository = statusRepository;
        this.newStatusMapper = newStatusMapper;
    }


    @Override
    public List<StatusResponse> getAll() {
        return  newStatusMapper.toResponseList(statusRepository.findAll());
    }

    @Override
    public StatusResponse get(Long id) {
        return newStatusMapper.toResponse(
                statusRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public StatusResponse create(StatusRequest statusRequest) {
        if (statusRequest == null) {
            throw new InvalidRequestException();
        }
        return newStatusMapper.toResponse(
                statusRepository.save(
                        newStatusMapper.toEntity(statusRequest)));
    }

    @Override
    public StatusResponse update(Long id, StatusRequest statusRequest) {
        if (statusRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        Status statusFromDb =
                statusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        statusFromDb.setStatusName(statusRequest.getStatusName());

        return newStatusMapper.toResponse(statusRepository.save(statusFromDb));
    }

    @Override
    public void delete(Long id) {
        statusRepository.deleteById(id);
    }
}
