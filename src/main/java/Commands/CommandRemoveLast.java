package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandRemoveLast implements Command{

    CollectionManager manager;

    public CommandRemoveLast(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.remove_last();
    }
}
