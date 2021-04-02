package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandClear implements Command{

    CollectionManager manager;

    public CommandClear(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.clear();
    }
}

