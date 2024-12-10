package in.rido.matcherservice.matcherservice.service.impl;

import in.rido.matcherservice.matcherservice.model.*;
import in.rido.matcherservice.matcherservice.service.MatcherService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class MatcherServiceImpl implements MatcherService {

  //this will come from configuration later
  private static final Integer MAX_DISTANCE = 50;
  private static final double WEIGHT_SKILLS = 0.3;
  private static final double WEIGHT_LOCATION = 0.2;
  private static final double WEIGHT_AVAILABILITY = 0.2;
  private static final double WEIGHT_PRICE = 0.1;
  private static final double WEIGHT_RATING = 0.1;
  private static final double WEIGHT_WORKLOAD = 0.1;

  @Override
  public List<TaskerMatch> matchTaskers(Job job, List<Tasker> taskersList) {

    return taskersList.stream()
            .map(tasker -> calculateTaskerScore(tasker, job))
            .filter(Objects::nonNull)
            .sorted(Comparator.comparing(TaskerMatch::getScore).reversed())
            .toList();
  }

  private static TaskerMatch calculateTaskerScore(Tasker tasker, Job job) {

    //this method will perform actual calculation after getting values from all score qualifiers
    double skillScore = calculateSkillScore(tasker.getSkills(), job.getRequiredSkills());
    double locationScore = calculateLocationScore(job.getLocation(), tasker.getLocation());
    double pricingScore = calculatePricingScore(job.getBudget(), tasker.getBasePrice());
    double availabilityScore = calculateAvailabilityScore(tasker.getAvailability(), job.getTime());

    double ratingScore = calculateRatingScore(tasker.getRating());

    // Workload score (based on current workload)
    double workloadScore = calculateWorkloadScore(tasker.getCurrentWorkload(), tasker.getMaxWorkload());

    // Aggregate score with dynamic weights
    double totalScore = (skillScore * WEIGHT_SKILLS) +
            (locationScore * WEIGHT_LOCATION) +
            (availabilityScore * WEIGHT_AVAILABILITY) +
            (pricingScore * WEIGHT_PRICE) +
            (ratingScore * WEIGHT_RATING) +
            (workloadScore * WEIGHT_WORKLOAD);

    // Only include taskers with a reasonable score
    if (totalScore < 0.5) return null; // Adjustable threshold

    return new TaskerMatch(tasker, totalScore);
  }

  private static double calculateSkillScore(List<String> taskerSkills, List<String> minimumRequiredSkills) {
    Set<String> minimumRequiredSkillSet = new HashSet<>(minimumRequiredSkills);
    Set<String> taskerSkillSet = new HashSet<>(taskerSkills);

    int commonSkills = (int) minimumRequiredSkillSet.stream().filter(taskerSkillSet::contains).count();
    return (double) commonSkills / minimumRequiredSkills.size();
  }

  private static double calculateLocationScore(Location job, Location tasker) {
    double haversineDistance = calculateHaversineDistance(job, tasker);
    if (haversineDistance > MAX_DISTANCE) return 0;
    return (1 - haversineDistance / MAX_DISTANCE);
  }

  private static double calculatePricingScore(Budget jobBudget, double taskerPrice) {
    if (taskerPrice < jobBudget.getMin() || taskerPrice > jobBudget.getMax()) return 0.0;
    return 1.0 - Math.abs(taskerPrice - jobBudget.getMax()) / jobBudget.getMax();
  }

  private static double calculateAvailabilityScore(List<TimeSlot> taskerAvailability, TimeSlot jobTime) {
    return taskerAvailability.stream().anyMatch(slot -> slot.overlaps(jobTime)) ? 1.0 : 0.0;
  }

  private static double calculateHaversineDistance(Location job, Location tasker) {
    final int EARTH_RADIUS = 6371; // Radius in km
    double latDiff = Math.toRadians(tasker.getLatitude() - job.getLatitude());
    double lonDiff = Math.toRadians(tasker.getLongitude() - job.getLongitude());
    double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) +
            Math.cos(Math.toRadians(job.getLatitude())) *
                    Math.cos(Math.toRadians(tasker.getLatitude())) *
                    Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
    return EARTH_RADIUS * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  }

  private static double calculateRatingScore(double rating) {
    // Normalize rating (assuming it's out of 5)
    return rating / 5.0;
  }

  private static double calculateWorkloadScore(int currentWorkload, int maxWorkload) {
    if (currentWorkload >= maxWorkload) return 0.0; // Tasker is fully booked
    return 1.0 - ((double) currentWorkload / maxWorkload); // Less workload = higher score
  }
}
