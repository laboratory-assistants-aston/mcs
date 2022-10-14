package ru.aston.mcs.service.fix;

import ru.aston.mcs.dto.request.StatusRequest;
import ru.aston.mcs.dto.response.StatusResponse;

import java.util.List;

public interface IStatusService {

    List<StatusResponse> getAll();

    StatusResponse get(Long id);

    StatusResponse create(StatusRequest statusRequest);

    StatusResponse update(Long id, StatusRequest statusRequest);

    void delete(Long id);
}
