package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandAverage implements Command{

    CollectionManager manager;

    public CommandAverage(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.average_of_living_space();
    }
}
