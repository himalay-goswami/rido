package in.rido.matcherservice.matcherservice.entity;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TaskerMatchMetadata {

  @Id
  private Long metadataId;

  @ElementCollection
  private List<String> jobMetadata;

}
