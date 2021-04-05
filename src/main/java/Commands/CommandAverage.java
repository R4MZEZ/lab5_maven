package Commands;

import Server.CollectionManager;

import java.util.Scanner;

public class CommandAverage implements Command{

    CollectionManager manager;
    final String name = "average_of_living_space";
    String argument;

    public CommandAverage(CollectionManager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        this.argument = argument;
        manager.average_of_living_space();
    }
}
