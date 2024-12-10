package in.karya.userservice.userservice.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskerOnboardResponseDTO {

  private String publicId;
  private String city;
  private Integer experienceYears;
  private List<String> skills;
  private Double trustScore;
  private boolean isVerified;
}
