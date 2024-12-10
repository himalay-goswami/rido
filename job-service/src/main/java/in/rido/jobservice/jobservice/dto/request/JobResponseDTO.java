package in.rido.jobservice.jobservice.dto.request;

import in.rido.jobservice.jobservice.enums.JobState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobResponseDTO {

  private Long jobId;
  private JobState jobState;

}
