package in.rido.jobservice.jobservice.model;

import in.rido.jobservice.jobservice.enums.JobState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String publicId; // Public-facing ID for safety

  @Column(nullable = false)
  private Long taskerId; // ID of the tasker performing the job

  @Column(nullable = false)
  private Long posterId; // ID of the user who posted the task

  @Column(nullable = false)
  private Long taskId; // Reference to the original task

  @Column(nullable = false)
  private Double basePrice; // Initial job price

  @Column(nullable = false)
  private Double totalPrice; // Adjusted price including steps

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private JobState state; // Job lifecycle state (e.g., IN_PROGRESS, COMPLETED)

  @Column(nullable = false)
  private LocalDateTime startTime;

  @Column
  private LocalDateTime endTime; // Populated when the job is completed
}
