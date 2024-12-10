package in.karya.userservice.userservice.service;

import in.karya.userservice.userservice.dto.request.TaskerOnboardRequestDTO;
import in.karya.userservice.userservice.dto.response.TaskerOnboardResponseDTO;
import in.karya.userservice.userservice.model.Tasker;
import in.karya.userservice.userservice.model.User;
import in.karya.userservice.userservice.repository.TaskerRepository;
import in.karya.userservice.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TaskerService {

  private final TaskerRepository taskerRepository;
  private final UserRepository userRepository;

  public TaskerService(TaskerRepository taskerRepository, UserRepository userRepository) {
    this.taskerRepository = taskerRepository;
    this.userRepository = userRepository;
  }

  @Value("classpath:skills.json")
  private Resource skillset;

//  private List<String> loadSkillsFromFile() throws IOException {
//    ObjectMapper mapper = new ObjectMapper();
//    JsonNode skills = mapper.readTree(skillset.getInputStream());
//    return mapper.convertValue(skills.get("jobTypes"), new TypeReference<>() {});
//  }

  //we are using user-name as identifier here, but need to change to public id later
  public TaskerOnboardResponseDTO onboardTasker(String userName, TaskerOnboardRequestDTO requestDTO) throws IOException {

    User user = userRepository.findByUsername(userName)
            .orElseThrow(() -> new UsernameNotFoundException("username not found"));

    Tasker tasker = Tasker.builder()
              .user(user)
              .city(requestDTO.getCity())
              .aadhaarNumber(requestDTO.getAadhaarNumber())
              .experienceYears(requestDTO.getExperienceYears())
              .skills(requestDTO.getSkills())
              .hourlyRate(requestDTO.getHourlyRate())
              .build();

      taskerRepository.save(tasker);

    return TaskerOnboardResponseDTO.builder()
            .city(tasker.getCity())
            .experienceYears(tasker.getExperienceYears())
            .isVerified(false)
            .publicId(user.getPublicId())
            .skills(tasker.getSkills())
            .trustScore(3.0)
            .build();
  }

//  private boolean validateSkills(List<String> skills) throws IOException {
//    List<String> allowedSkills = loadSkillsFromFile();
//
//    for(String skill: skills){
//      if(!allowedSkills.contains(skill)) {
//        throw new IllegalArgumentException("skill not found: " + skill);
//      }
//    }
//    return true;
//  }

//  private boolean validateUser(TaskerOnboardRequestDTO dto) {
//    if (dto.getCity() == null || dto.getCity().isEmpty()) {
//      throw new IllegalArgumentException("City cannot be empty");
//    }
//
//    if (!dto.getAadhaarNumber().matches("\\d{12}")) {
//      throw new IllegalArgumentException("Aadhaar number is invalid");
//    }
//    return true;
//  }
}
