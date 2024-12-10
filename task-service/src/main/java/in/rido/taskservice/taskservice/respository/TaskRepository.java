package in.rido.taskservice.taskservice.respository;

import in.rido.taskservice.taskservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
