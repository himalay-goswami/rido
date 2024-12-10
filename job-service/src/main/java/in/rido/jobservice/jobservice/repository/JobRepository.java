package in.rido.jobservice.jobservice.repository;

import in.rido.jobservice.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
