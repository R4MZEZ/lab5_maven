package Commands;

import Server.CollectionManager;

import java.util.Scanner;

public class CommandClear implements Command{

    CollectionManager manager;
    final String name = "clear";
    String argument;

    public CommandClear(CollectionManager manager) {
        this.manager = manager;
    }

//    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        this.argument = argument;
        manager.clear();
    }
}

