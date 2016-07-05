package info.bencollier.adventure;

/**
 * Created by ben on 05/07/16.
 */

import java.util.HashMap;

public class Location {

    public String name;
    public String description;
    public HashMap<String, Location> destinations;

    public Location(String start_name, String start_description) {
        name = start_name;
        description = start_description;
        destinations = new HashMap<String, Location>();
    }

}
