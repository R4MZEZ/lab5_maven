package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandRemoveAt implements Command{

    CollectionManager manager;

    public CommandRemoveAt(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.remove_at(argument);
    }
}
