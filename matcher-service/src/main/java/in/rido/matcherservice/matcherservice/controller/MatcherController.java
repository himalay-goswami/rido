package in.rido.matcherservice.matcherservice.controller;


import in.rido.matcherservice.matcherservice.dto.request.MatcherRequestDTO;
import in.rido.matcherservice.matcherservice.model.Job;
import in.rido.matcherservice.matcherservice.model.TaskerMatch;
import in.rido.matcherservice.matcherservice.service.MatcherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matcher")
public class MatcherController {

  private final MatcherService matcherService;

  public MatcherController(MatcherService matcherService) {
    this.matcherService = matcherService;
  }

  @GetMapping("/match")
  public ResponseEntity<List<TaskerMatch>> matchTaskersForJob(@RequestBody MatcherRequestDTO matcherRequestDTO) {
    Job job = matcherRequestDTO.getJob();
    return ResponseEntity.ok(matcherService.matchTaskers(job, null));
  }
}
