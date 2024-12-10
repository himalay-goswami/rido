package in.rido.taskservice.taskservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  private Long userId;
  private String name;
  private String email;
  private String phoneNumber;
  private String role;
}
