package in.rido.jobservice.jobservice.model;

import in.rido.jobservice.jobservice.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_user_map")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobUserMap {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long jobId; // Reference to the Job entity

  @Column(nullable = false)
  private Long userId; // Reference to the User entity

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
    private UserRole role; // Role of the user in the job (e.g., TASKER, POSTER, SUPERVISOR)

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime updatedAt;
}
