package App;

import Post.Post;
import User.User;
import java.util.Scanner;

public class App {

  public static void initialUsers(AppUsers appUsers) {
    Scanner input = new Scanner(System.in);
    int numberUsers = input.nextInt();
    User[] newUsers = new User[numberUsers];
    for (int i=0; i<numberUsers; i++){
      String newUserName = input.next();
      newUsers[i] = new User(newUserName);
    }
    appUsers.setUsers(newUsers);
  }

  public static void initialFollows(AppUsers appUsers){
    Scanner input = new Scanner(System.in);
    int numberFollows = input.nextInt();
    User[] users = appUsers.getUsers();
    for (int i=0; i<numberFollows; i++) {
      String userName = input.next();
      String userTargetName = input.next();
      int userIndex = appUsers.indexOf(userName);
      int userTargetIndex = appUsers.indexOf(userTargetName);
      if(userIndex >= 0 && userTargetIndex >= 0) // found
        users[userIndex].follow(users[userTargetIndex]);
    }
  }

  public static void initialNewFeeds(AppUsers appUsers, NewFeeds newFeeds){
    Scanner input = new Scanner(System.in);
    int numberPosts = input.nextInt();
    input.nextLine();
    User[] users = appUsers.getUsers();
    Post[] newPosts = new Post[numberPosts];
    for(int i=0; i<numberPosts; i++){
      String newPost = input.nextLine();
      newPost.replace("\\s", "");
      int slashIndex = newPost.indexOf("/");
      String newPostUserName = newPost.substring(0, slashIndex);
      String newPostMessage = newPost.substring(slashIndex+1);
      int userIndex = appUsers.indexOf(newPostUserName);
      newPosts[i] = new Post(users[userIndex], newPostMessage);
    }
    newFeeds.setPosts(newPosts);
  }


  public static void main(String[] args) {
    AppUsers appUsers = new AppUsers();
    NewFeeds newFeeds = new NewFeeds(appUsers);
    initialUsers(appUsers);
    initialFollows(appUsers);
    initialNewFeeds(appUsers, newFeeds);
    newFeeds.printFeeds();
  }
}
