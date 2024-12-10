package in.rido.jobservice.jobservice.dto.response;

import in.rido.jobservice.jobservice.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobRequestDTO {

  private String jobId;
  private String userId;
  private String taskDescription;
  private String initialBiddingAmount;
  private List<User> taskerAssigned;
}
