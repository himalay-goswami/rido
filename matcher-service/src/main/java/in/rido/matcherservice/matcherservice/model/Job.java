package in.rido.matcherservice.matcherservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Job {

  private String id;
  private Location location;
  private List<String> requiredSkills;
  private TimeSlot time;
  private Budget budget;

}
