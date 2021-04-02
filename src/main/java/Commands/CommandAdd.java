package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandAdd implements Command{

    CollectionManager manager;

    public CommandAdd(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.add(reader);
    }
}

