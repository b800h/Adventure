package info.bencollier.adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Game {

    private int score = 0;
    private boolean alive = true;
    private Location location;
    private ArrayList<Location> locations;
    private ArrayList<Item> items;

    Map<String, Consumer<String>> commands = new HashMap<>();

    public Game(Location start_location, ArrayList start_items, ArrayList start_locations) {
        location = start_location;
        locations = start_locations;
        items = start_items;

        // Populate commands map
        commands.put("north", (String item) -> move("north"));
        commands.put("south", (String item) -> move("south"));
        commands.put("west", (String item) -> move("west"));
        commands.put("east", (String item) -> move("east"));
        commands.put("in", (String item) -> move("in"));
        commands.put("out", (String item) -> move("out"));
        commands.put("get", (String item) -> get(item));
        commands.put("drop", (String item) -> drop(item));
        commands.put("inventory", (String item) -> inventory(item));
        commands.put("help", (String item) -> help(item));
        commands.put("examine", (String item) -> examine(item));
        commands.put("look", (String item) -> look());
    }

    public void parse(String command) {

        // Split string into words
        String parsed_command[] = command.split(" ");
        Consumer action = commands.get(parsed_command[0]);
        if (action != null) {
            if (parsed_command.length > 1) {
                action.accept(parsed_command[1]);
            }
            else {
                action.accept("");
            }
        }
        else {
            System.out.println("Command not understood!");
        }
    }


    public int play() {

        String command;
        Scanner user_input = new Scanner(System.in);

        look();

        while (alive == true) {

            // Describe current location

            System.out.print("> ");
            command = user_input.nextLine();
            parse(command);

        }

        return score;
    }

    private void look() {
        System.out.println(location.description);
        for (Item look_item : items) {
            if (look_item.location == location && !look_item.carried) {
                System.out.println(String.format("There is a %s here", look_item.name));
            }
        }
    }

    private void move(String direction) {
        Location destination = location.destinations.get(direction);
        if (destination != null) {
            System.out.println("Moved");
            location = destination;
            look();
        }
        else {
            System.out.println("You cannot move in that direction");
        }

    }

    private void get(String item) {
        for (Item get_item: items) {
            if (get_item.name.equals(item) && !get_item.carried) {
                get_item.carried = true;
                System.out.println(String.format("You get the %s.", get_item.name));
            }
        }
    }

    private void drop(String item) {
        for (Item drop_item: items) {
            if (drop_item.name.equals(item) && drop_item.carried) {
                drop_item.location = location;
                drop_item.carried = false;
                System.out.println(String.format("You drop the %s.", drop_item.name));
            }
        }
    }

    public void inventory(String item) {
        System.out.println("You are carrying:");
        for (Item drop_item: items) {
            if (drop_item.carried) {
                System.out.println(drop_item.name);
            }
        }
    }

    public void help(String item) {
        System.out.println("The following commands are available:");
        for (Map.Entry<String, Consumer<String>> entry: commands.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void examine(String item) {
        for (Item examine_item: items) {
            if (examine_item.carried || examine_item.location == location) {
                System.out.println(examine_item.description);
            }
        }
    }

}
