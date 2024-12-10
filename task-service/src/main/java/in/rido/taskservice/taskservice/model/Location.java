package in.rido.taskservice.taskservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Location {

  private String latitude;
  private String longitude;
  private String city;

  @Override
  public String toString() {
    return "Location{" +
            "latitude='" + latitude + '\'' +
            ", longitude='" + longitude + '\'' +
            ", city='" + city + '\'' +
            '}';
  }
}
