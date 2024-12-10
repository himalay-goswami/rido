package in.rido.taskservice.taskservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Bid {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bidId;

  private String posterId;
  private String taskerId;

  private String price;
  private String message;
  private String createdAt;

  @OneToOne
  private PostStatus postStatus;
}
