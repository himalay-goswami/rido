package in.karya.userservice.userservice.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

  private String publicId;
  private String username;
  private String email;
  private String role;
}