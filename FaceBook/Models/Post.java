package FaceBook.Models;

import java.io.Serializable;

public class Post implements Serializable {
    private String sub;
    private String description;

    public Post(String sub, String description) {
        this.sub = sub;
        this.description = description;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
