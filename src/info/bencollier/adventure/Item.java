package info.bencollier.adventure;

import java.util.HashMap;

/**
 * Created by ben on 05/07/16.
 */
public class Item {

    public Location location;
    public String name;
    public Boolean carried;
    public String description;

    public Item(Location start_location, String start_name, Boolean start_carried, String start_description) {
        location = start_location;
        name = start_name;
        carried = start_carried;
        description = start_description;
    }

}
