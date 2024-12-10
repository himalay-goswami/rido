package in.rido.taskservice.taskservice.model;

import in.rido.taskservice.taskservice.model.enums.PostStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class PostStatus {

  @Id
  private String statusId;

  private PostStatusEnum postStatus;
  private String description;

}
