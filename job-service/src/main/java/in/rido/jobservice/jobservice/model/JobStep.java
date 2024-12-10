package in.rido.jobservice.jobservice.model;

import in.rido.jobservice.jobservice.enums.JobState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_steps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobStep {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long jobId; // Reference to the parent job

  @Column(nullable = false)
  private String description; // Step description (e.g., "Buy milk")

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private JobState state; // Step status (e.g., PENDING, COMPLETED)

  @Column(nullable = false)
  private Double priceAdjustment; // Price change for this step

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime completedAt; // Populated when the step is completed
}
