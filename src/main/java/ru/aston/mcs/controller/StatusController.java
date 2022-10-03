package ru.aston.mcs.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.service.StatusServiceI;
import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusServiceI statusService;

    public StatusController(StatusServiceI statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/")
    public List<StatusDTO> getAllStatus() {
        return statusService.getAllStatus();
    }

    @GetMapping("/{id}")
    public StatusDTO getStatus(@PathVariable Long id) {
        return statusService.getStatus(id);
    }

    @PostMapping("/")
    public void saveStatus(@RequestBody StatusDTO statusDTO) {
        statusService.addAndSaveStatus(statusDTO);
    }

    @PutMapping("/")
    public void updateStatus(@RequestBody StatusDTO statusDTO) {
        statusService.addAndSaveStatus(statusDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}