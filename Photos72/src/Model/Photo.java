package Model;

import java.util.ArrayList;
import java.util.List;

public class Photo {

    private List<Tag> tagList = new ArrayList<Tag>();
    public Photo(){
        
    }

    public boolean dupTag(Tag x){
        for (Tag tag : tagList) {
            if (tag.name.equals(x.name) && tag.value.equals(x.value)) {
                return true;
            }
        }

        return false;
    }

}
