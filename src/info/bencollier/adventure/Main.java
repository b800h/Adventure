package info.bencollier.adventure;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create Locations

        ArrayList<Location> locations = new ArrayList<Location>();

        Location loc1 = new Location("Home", "You are outside your house.");
        Location loc2 = new Location("House", "You are inside your house");

        locations.add(loc1);
        locations.add(loc2);

        // Link Locations

        loc1.destinations.put("in", loc2);
        loc2.destinations.put("out", loc1);

        // Create Items

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(loc1, "Lamp", false, "A bronze lamp. It shines as though lit by magic."));
        items.add(new Item(loc1, "Letter", true, "Dear player, it is your task to amass 100 gold coins, and give them to the wise elf. Good luck!"));

        // Initialise game

        Game game = new Game(loc1, items, locations);

        // Jump to main loop

        game.play();

    }

}