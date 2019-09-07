package Post;

import User.User;

public class Post {
  private User user;
  private String message;

  public Post(User user, String message) {
    this.user = user;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public User getUser() {
    return user;
  }
}
