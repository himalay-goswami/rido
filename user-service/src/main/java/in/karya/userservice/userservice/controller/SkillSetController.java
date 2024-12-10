package in.karya.userservice.userservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/skillset")
public class SkillSetController {

  @Value("classpath:skills.json")
  private Resource skillset;


  @GetMapping("/skills")
  public ResponseEntity<JsonNode> getSkillset() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode skills = mapper.readTree(skillset.getInputStream());
    return ResponseEntity.ok(skills);
  }
}
