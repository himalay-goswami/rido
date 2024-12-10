package in.karya.userservice.userservice.controller;

import in.karya.userservice.userservice.dto.response.TaskerOnboardResponseDTO;
import in.karya.userservice.userservice.service.TaskerService;
import in.karya.userservice.userservice.wrapper.TaskerWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/tasker")
public class TaskerController {

  private final TaskerService taskerService;

  public TaskerController(TaskerService taskerService) {
    this.taskerService = taskerService;
  }

  @PostMapping("/onboard")
  public ResponseEntity<TaskerOnboardResponseDTO> onboardTasker(@RequestBody TaskerWrapper taskerWrapper) throws IOException {
    TaskerOnboardResponseDTO dto = taskerService.onboardTasker(taskerWrapper.getUserName(), taskerWrapper.getTaskerOnboardRequestDTO());
    return ResponseEntity.ok(dto);
  }


}
