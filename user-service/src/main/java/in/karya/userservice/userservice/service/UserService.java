package in.karya.userservice.userservice.service;

import in.karya.userservice.userservice.dto.response.UserResponseDTO;
import in.karya.userservice.userservice.utils.IdGeneratorUtil;
import in.karya.userservice.userservice.utils.UserType;
import in.karya.userservice.userservice.dto.request.UserRequestDTO;
import in.karya.userservice.userservice.exception.UserAlreadyExistsException;
import in.karya.userservice.userservice.model.User;
import in.karya.userservice.userservice.repository.UserRepository;
import in.karya.userservice.userservice.utils.MessageConstants;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = bCryptPasswordEncoder;
  }

  public UserResponseDTO registerUser(UserRequestDTO userRequestDTO)
  {
    if(userRepository.existsByEmail(userRequestDTO.getEmail())){
      throw new UserAlreadyExistsException(MessageConstants.USER_EMAIL_ALREADY_EXISTS + userRequestDTO.getEmail());
    }

    if(userRepository.existsByUsername(userRequestDTO.getUsername())){
      throw new UserAlreadyExistsException(MessageConstants.USER_USERNAME_ALREADY_EXISTS + userRequestDTO.getUsername());
    }

    User user = User.builder()
            .username(userRequestDTO.getUsername())
            .email(userRequestDTO.getEmail())
            .publicId(IdGeneratorUtil.idGenerator())
            .password(passwordEncoder.encode(userRequestDTO.getPassword()))
            .role(UserType.valueOf(userRequestDTO.getRole()))
            .registeredOn(LocalDateTime.now())
            .build();

    userRepository.save(user);

    return UserResponseDTO.builder()
            .publicId(user.getPublicId())
            .username(user.getUsername())
            .email(user.getEmail())
            .role(user.getRole().name())
            .build();
  }
}
