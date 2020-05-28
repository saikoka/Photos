package Model;

import java.util.ArrayList;
import java.util.List;

public class Album implements Comparable<Album>{
    private String albumName;
    private List<Photo> photoList = new ArrayList<Photo>();
    public Album(String albumName){
        this.albumName=albumName;
    }

    public String getAlbumName(){
        return albumName;
    }

    public void setAlbumName(String albumName){
        this.albumName=albumName;
    }


    public void addPhoto(Photo x){
        photoList.add(x);
    }


    @Override
    public int compareTo(Album o) {
        String x = this.albumName;
        String y = o.albumName;
        return x.compareTo(y);
    }

    @Override
    public String toString(){
        return albumName;
    }
}
