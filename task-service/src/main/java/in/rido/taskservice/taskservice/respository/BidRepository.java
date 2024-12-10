package in.rido.taskservice.taskservice.respository;

import in.rido.taskservice.taskservice.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
