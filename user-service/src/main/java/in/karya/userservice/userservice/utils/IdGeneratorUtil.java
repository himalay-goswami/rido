package in.karya.userservice.userservice.utils;

import java.security.SecureRandom;

public class IdGeneratorUtil {

  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  private static final SecureRandom RANDOM = new SecureRandom();

  public static String idGenerator() {

    StringBuilder publicId = new StringBuilder();

    for(int i=0; i<8; i++){
      int randomIndex = RANDOM.nextInt(CHARACTERS.length());
      publicId.append(CHARACTERS.charAt(randomIndex));
    }
    return publicId.toString();
  }
}
