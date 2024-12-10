package in.karya.userservice.userservice.controller;

import in.karya.userservice.userservice.dto.request.UserRequestDTO;
import in.karya.userservice.userservice.dto.response.UserResponseDTO;
import in.karya.userservice.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequest){
    return ResponseEntity.ok(userService.registerUser(userRequest));
  }
}