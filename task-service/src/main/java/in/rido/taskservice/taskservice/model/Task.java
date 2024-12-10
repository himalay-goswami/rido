package in.rido.taskservice.taskservice.model;


import in.rido.taskservice.taskservice.model.enums.PostStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long taskId;

  private String title;

  private String posterId;

  private String description;

  private String createdAt;

  private String updatedAt;

  private String categoryId;

  private String budget;

  private String statusId;
  private PostStatusEnum taskStatus;

  @ElementCollection
  private List<String> requiredSkills; //this needs to be calculated from task metadata

}
