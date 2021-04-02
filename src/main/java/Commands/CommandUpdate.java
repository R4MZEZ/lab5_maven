package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandUpdate implements Command{

    CollectionManager manager;

    public CommandUpdate(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.update(argument, reader);
    }
}

