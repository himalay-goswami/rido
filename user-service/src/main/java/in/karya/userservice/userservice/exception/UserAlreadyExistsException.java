package in.karya.userservice.userservice.exception;

public class UserAlreadyExistsException extends RuntimeException{

  public UserAlreadyExistsException(String message){
    super(message);
  }
}
