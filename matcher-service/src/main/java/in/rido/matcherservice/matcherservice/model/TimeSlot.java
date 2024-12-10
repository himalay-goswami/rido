package in.rido.matcherservice.matcherservice.model;

import java.time.LocalDateTime;

public class TimeSlot {

  private LocalDateTime start;
  private LocalDateTime end;

  public boolean overlaps(TimeSlot other) {
    return start.isBefore(other.end) && end.isAfter(other.start);
  }
}
