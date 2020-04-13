package Model;

import java.util.ArrayList;
import java.util.List;

public class Photo {

    private List<Tag> tagList = new ArrayList<Tag>();
    private String caption;
    public Photo(){
        
    }

    public boolean dupTag(Tag x){
        for (Tag tag : tagList) {
            if (tag.getName().equals(x.getName()) && tag.getValue().equals(x.getValue())) {
                return true;
            }
        }

        return false;
    }

    public void addTag(Tag x){
        if(!dupTag(x)){
            tagList.add(x);
        }
    }

    public List<Tag> getTagList(){
        return tagList;
    }

}
