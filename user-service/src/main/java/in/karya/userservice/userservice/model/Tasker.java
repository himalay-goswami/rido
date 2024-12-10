package in.karya.userservice.userservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasker")
public class Tasker {

  @Id
  @Column(name = "user_id")
  private Long userId;

  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  @MapsId
  @OneToOne
  private User user;

  // Worker-Specific Fields
  @Column(name = "skills")
  @ElementCollection
  private List<String> skills; // e.g., ["Plumbing", "Design", "Writing"]

  @Column(name = "experience_years")
  private Integer experienceYears;

  @Column(name = "hourly_rate")
  private Double hourlyRate;

  @Column(name = "availability_status")
  private String availabilityStatus; // e.g., AVAILABLE, BUSY, OFFLINE

  @Column(name = "professional_flags")
  @ElementCollection
  private List<String> professionalflags;

  @Column(name = "trust_rank", precision = 2)
  private Double trustRank;

  @Column(name = "aadhaar_number", nullable = false, unique = true)
  private String aadhaarNumber;

  @Column(name = "city")
  private String city;
}
