package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.mapper.HousekeeperMapper;
import ru.aston.mcs.repository.HousekeeperRepository;
import ru.aston.mcs.service.HousekeeperService;

import java.util.List;

@Service
@Transactional
public class HousekeeperServiceImpl implements HousekeeperService {

    private final HousekeeperRepository housekeeperRepository;
    private final HousekeeperMapper housekeeperMapper;

    public HousekeeperServiceImpl(HousekeeperRepository housekeeperRepository, HousekeeperMapper housekeeperMapper) {
        this.housekeeperRepository = housekeeperRepository;
        this.housekeeperMapper = housekeeperMapper;
    }

    @Override
    public HousekeeperDTO getHousekeeper(Long housekeeperId) {
        return housekeeperMapper.toDTO(
                housekeeperRepository.findById(housekeeperId)
                        .orElse(null));
    }

    @Override
    public List<HousekeeperDTO> getAllHousekeepers() {
        return housekeeperMapper.toDTOList(housekeeperRepository.findAll());
    }

    @Override
    public void addAndSaveHousekeeper(HousekeeperDTO housekeeperDTO) {
        housekeeperRepository.save(housekeeperMapper.toModel(housekeeperDTO));

    }

    @Override
    public void deleteHousekeeper(Long housekeeperId) {
        housekeeperRepository.deleteById(housekeeperId);
    }
}
