package App;
import Post.Post;
import User.User;
import java.util.HashSet;

public class NewFeeds {
  private Post[] posts;
  private AppUsers appUsers;

  public NewFeeds(AppUsers appUsers){
    this.appUsers = appUsers;
  }

  public Post[] getPosts() {
    return posts;
  }

  public void setPosts(Post[] posts) {
    this.posts = posts;
  }

  public void printFeeds(){
    User[] users = this.appUsers.getUsers();
    Post[] posts = getPosts();
    for(User user: users){
      System.out.println(user.getName() + ":");
      HashSet<User> userFollows = user.getFollows();
      for(Post post: posts){
        User postUser = post.getUser();
        if(userFollows.contains(postUser))
          System.out.println("(" + postUser.getName() + ") " + post.getMessage());
      }
    }
  }
}
