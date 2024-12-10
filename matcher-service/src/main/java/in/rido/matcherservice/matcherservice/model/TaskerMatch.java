package in.rido.matcherservice.matcherservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskerMatch {

  private Tasker tasker;
  private double score;

  public TaskerMatch(Tasker tasker, double score) {
    this.tasker = tasker;
    this.score = score;
  }
}
