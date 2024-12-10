package in.karya.userservice.userservice.dto.request;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskerOnboardRequestDTO {

  private String city;
  private String aadhaarNumber;
  private Integer experienceYears;
  private List<String> skills;
  private Double hourlyRate;

}
