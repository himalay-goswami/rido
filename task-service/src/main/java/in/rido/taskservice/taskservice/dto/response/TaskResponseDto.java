package in.rido.taskservice.taskservice.dto.response;

import in.rido.taskservice.taskservice.model.PostStatus;
import in.rido.taskservice.taskservice.model.enums.PostStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TaskResponseDto implements Serializable {

  private String taskId;
  private String title;
  private PostStatusEnum postStatus;
  private String createdAt;
}
