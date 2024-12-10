package in.rido.taskservice.taskservice.dto.request;


import in.rido.taskservice.taskservice.model.Location;
import in.rido.taskservice.taskservice.model.PostAttachment;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TaskRequestDto implements Serializable {

  private String title;
  private String budget;
  private String description;
  private Integer[] budgetRange;
  private String categoryId;
  private Location location;
  private PostAttachment attachments;

}
