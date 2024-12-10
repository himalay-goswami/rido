package in.rido.matcherservice.matcherservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tasker {

  private String id;
  private Location location;
  private List<String> skills;
  private List<TimeSlot> availability;
  private double basePrice;
  private double rating; // Out of 5
  private List<String> jobPreferences;
  private int currentWorkload;
  private int maxWorkload;
}
