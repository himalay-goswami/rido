package in.rido.jobservice.jobservice.service;

import in.rido.jobservice.jobservice.dto.request.JobResponseDTO;
import in.rido.jobservice.jobservice.dto.response.JobRequestDTO;
import in.rido.jobservice.jobservice.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {

  private final JobRepository jobRepository;

  public JobService(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  public JobResponseDTO createJob(JobRequestDTO jobRequestDTO) {
return
        null;

  }

}
