package in.rido.taskservice.taskservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class PostAttachment {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private String attachmentId;
  private String postId;
  private String attachmentName;
  private String uploadedAt;
  private String filePath;
  private String fileType;
}
