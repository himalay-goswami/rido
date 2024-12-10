package in.rido.taskservice.taskservice.controller;


import in.rido.taskservice.taskservice.dto.request.TaskRequestDto;
import in.rido.taskservice.taskservice.dto.response.TaskResponseDto;
import in.rido.taskservice.taskservice.model.Task;
import in.rido.taskservice.taskservice.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bid")
public class BidController {

  private final TaskService taskService;

  public BidController(TaskService taskService) {
    this.taskService = taskService;
  }

  public String addBidToTask() {
    return "";
  }

  @GetMapping("/_searchTask")
  public Optional<TaskResponseDto> getTaskDetails(@RequestBody Long taskId){
    return Optional.of(taskService.getTaskDetails(taskId));
  }
}
