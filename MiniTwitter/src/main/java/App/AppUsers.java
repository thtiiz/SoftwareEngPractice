package App;
import App.Utils.Indexable;
import User.User;

public class AppUsers implements Indexable {

  private User[] users;

  public User[] getUsers() {
    return this.users;
  }

  public void setUsers(User[] users) {
    this.users = users;
  }

  public int indexOf(Object val){
    User[] users = this.getUsers();
    String userName = (String)val;
    for(int i=0; i<users.length; i++){
      if(users[i].getName().compareTo(userName) == 0)
        return i;
    }
    return -1; // not found
  }
}
