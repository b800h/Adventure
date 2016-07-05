package info.bencollier.adventure;

public class Main {

    public static void main(String[] args) {

        // Create Locations

        Location loc1 = new Location("Home", "You are outside your house.");
        Location loc2 = new Location("House", "You are inside your house");

        // Link Locations

        loc1.destinations.put("In", loc2);

        // Initialise game

        Game game = new Game(loc1);

        // Jump to main loop

        game.play();

    }

}