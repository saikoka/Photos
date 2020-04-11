package Model;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private List<Photo> photoList = new ArrayList<Photo>();
    public Album(){

    }

    public void addPhoto(Photo x){
        photoList.add(x);
    }


}
