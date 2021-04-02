package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandHelp implements Command {

    CollectionManager manager;

    public CommandHelp(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.help();
    }
}
