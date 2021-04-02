package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandInfo implements Command {

    CollectionManager manager;

    public CommandInfo(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.info();
    }
}
