package Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    private List<Album> albumList= new ArrayList<Album>();
    public static List<User> userList=new ArrayList<User>();
    public User(String username){
        this.username=username;
        userList.add(this);
    }
}
