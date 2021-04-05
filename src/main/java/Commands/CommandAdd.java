package Commands;

import Server.CollectionManager;

import java.util.Scanner;

public class CommandAdd implements Command{

    CollectionManager manager;
    final String name = "add";
    String argument;

    public CommandAdd(CollectionManager manager) {
        this.manager = manager;
    }

//    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        this.argument = argument;
        manager.add(reader);
    }
}

