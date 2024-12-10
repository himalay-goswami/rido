package in.karya.userservice.userservice.repository;

import in.karya.userservice.userservice.model.Tasker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskerRepository extends JpaRepository<Tasker, Long> {

}
