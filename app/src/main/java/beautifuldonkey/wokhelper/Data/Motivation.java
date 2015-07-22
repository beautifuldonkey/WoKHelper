package beautifuldonkey.wokhelper.Data;

/**
 * defining motivations to be selected before battle begins
 * Created by user on 7/22/2015.
 */
public class Motivation {
    private String name;
    private String description;

    public Motivation(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
