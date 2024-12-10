package in.karya.userservice.userservice.model;


import in.karya.userservice.userservice.utils.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId; //this should be private id, for internal purposes. Should NEVER be returned

  @Column(name = "public_id", nullable = false, unique = true)
  private String publicId;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private UserType role;

  @Column(name = "phone_number", unique = true)
  private String phoneNumber;

  @Column(name = "registered_on", nullable = false)
  private LocalDateTime registeredOn;

  @Column(name = "verified")
  private Boolean verified; //just a way to establish a person's identity, it has nothing to do with user type

  // Audit Fields
  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @Column(name = "updated_on")
  private LocalDateTime updatedOn;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private Tasker tasker;
}
