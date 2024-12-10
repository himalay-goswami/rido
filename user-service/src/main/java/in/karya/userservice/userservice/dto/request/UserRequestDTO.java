package in.karya.userservice.userservice.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
  private String username;
  private String password;
  private String email;
  private String role; // e.g.
}