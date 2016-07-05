package info.bencollier.adventure;

import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private int score = 0;
    private boolean alive = true;
    private Location location;

    public Game(Location start_location) {
        location = start_location;
    }

    public int play() {

        String command;
        Scanner user_input = new Scanner(System.in);

        look();

        while (alive == true) {

            // Describe current location

            System.out.print("> ");
            command = user_input.next();
            parse(command);

        }

        return score;
    }

    public void parse(String command) {
        // Define parser
        HashMap<String, Runnable> commands = new HashMap<>();

        // Split string into words
        String parsed_command[] = command.split(" ");

        // Populate commands map
        commands.put("look", () -> look());
        commands.put("north", () -> move("north"));

        commands.get(parsed_command[0]).run();

        //

    }

    public void look() {
        System.out.println(location.description);
    }

    public void move(String direction) {
        System.out.println("Moved north");
        look();
    }

    public void get() {

    }

    public void drop() {

    }

    public void inv() {

    }

    public void help() {

    }

}
