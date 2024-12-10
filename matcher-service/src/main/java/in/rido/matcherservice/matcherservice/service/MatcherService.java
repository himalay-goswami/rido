package in.rido.matcherservice.matcherservice.service;

import in.rido.matcherservice.matcherservice.model.Job;
import in.rido.matcherservice.matcherservice.model.Tasker;
import in.rido.matcherservice.matcherservice.model.TaskerMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatcherService {

  //input data for this method will be collected in a stream which keeps an eye on available taskers
  List<TaskerMatch> matchTaskers(Job job, List<Tasker> taskersList);

}
