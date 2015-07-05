package homelessless.govhack.org.homelessless.models;

import java.io.Serializable;

public class Category implements Serializable {
    private long _id;
    private String title;

    public Category(long id, String title) {
        this._id = id;
        this.title = title;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
