package in.rido.taskservice.taskservice.controller;

import in.rido.taskservice.taskservice.dto.request.TaskRequestDto;
import in.rido.taskservice.taskservice.dto.response.TaskResponseDto;
import in.rido.taskservice.taskservice.model.Task;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import static in.rido.taskservice.taskservice.model.enums.PostStatusEnum.PENDING;

@RestController
@RequestMapping("/api/v1/task-service")
public class TaskController {

  @PostMapping("/_create")
  public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto taskRequestDto){

    Task task = Task.builder()
            .title(taskRequestDto.getTitle())
            .budget(taskRequestDto.getBudget())
            .description(taskRequestDto.getDescription())
            .createdAt(LocalTime.now().toString())
            .taskStatus(PENDING)
            .requiredSkills(null)  // TODO fetch skills from task description using matcher/regex
            .categoryId(taskRequestDto.getCategoryId())
            .posterId(taskRequestDto.toString())
            .build();

    TaskResponseDto dto = new TaskResponseDto();
    dto.setCreatedAt(task.getCreatedAt());
    dto.setTaskId(task.getTaskId().toString());
    dto.setPostStatus(task.getTaskStatus());

    return new ResponseEntity<>(HttpStatusCode.valueOf(200));
  }
}
