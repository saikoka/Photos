package Model;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>{
    private String username;
    private List<Album> albumList= new ArrayList<Album>();
    public static List<User> userList=new ArrayList<User>();
    public User(String username){
        this.username=username;
        userList.add(this);
    }

    public String getUsername(){
        return username;
    }

    public List<Album> getAlbumList(){
        return albumList;
    }

    public void setAlbumList(List<Album> albumList){
        this.albumList=albumList;
    }

    public static boolean findUser(String x){
        for(User user: userList){
            if(user.username.equals(x)){
                return true;
            }
        }
        return false;
    }

    public boolean findAlbum(String x){
        for(Album alb: albumList){
            if(alb.getAlbumName().equals(x)){
                return true;
            }
        }
        return false;
    }
    public void createAlbum(Album x){
        albumList.add(x);
    }

    @Override
    public String toString(){
        return username;
    }


    @Override
    public int compareTo(User o) {
        String x = this.username;
        String y = o.username;
        return x.compareTo(y);
    }


}
