package in.rido.matcherservice.matcherservice.dto.request;

import in.rido.matcherservice.matcherservice.model.Job;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatcherRequestDTO {

  private Job job;
}
