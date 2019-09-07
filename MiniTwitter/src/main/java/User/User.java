package User;
import java.util.HashSet;

public class User {
  private String name;
  private HashSet<User> follows;

  public User(String name) {
    this.name = name;
    this.follows = new HashSet<User>();
    this.follows.add(this);
  }

  public String getName() {
    return name;
  }

  public HashSet<User> getFollows() {
    return this.follows;
  }

  public void follow(User otherUser) {
    this.follows.add(otherUser);
  }

}
