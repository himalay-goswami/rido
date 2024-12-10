package in.rido.taskservice.taskservice.service;

import in.rido.taskservice.taskservice.respository.BidRepository;
import org.springframework.stereotype.Service;

@Service
public class BidService {

  private final BidRepository bidRepository;

  public BidService(BidRepository bidRepository) {
    this.bidRepository = bidRepository;
  }

  
}
