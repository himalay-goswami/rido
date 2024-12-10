package in.rido.taskservice.taskservice.service;

import in.rido.taskservice.taskservice.dto.request.TaskRequestDto;
import in.rido.taskservice.taskservice.dto.response.TaskResponseDto;
import in.rido.taskservice.taskservice.model.Task;
import in.rido.taskservice.taskservice.respository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
    Task task = new Task();
    BeanUtils.copyProperties(taskRequestDto, task);
    taskRepository.save(task);

    TaskResponseDto dto = new TaskResponseDto();
    BeanUtils.copyProperties(task, dto);

    return dto;
  }

  public TaskResponseDto getTaskDetails(Long taskId){

    Optional<Task> task = taskRepository.findById(taskId);
    TaskResponseDto dto = new TaskResponseDto();
    BeanUtils.copyProperties(task, dto);
    return dto;
  }
}
