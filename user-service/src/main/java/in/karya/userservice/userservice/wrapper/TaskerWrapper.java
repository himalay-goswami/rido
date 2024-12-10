package in.karya.userservice.userservice.wrapper;

import in.karya.userservice.userservice.dto.request.TaskerOnboardRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskerWrapper {

  private String userName;
  private TaskerOnboardRequestDTO taskerOnboardRequestDTO;

}
