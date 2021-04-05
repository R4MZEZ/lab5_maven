package Commands;

import Server.CollectionManager;

import java.util.Scanner;

public class CommandShow implements Command {

    CollectionManager manager;

    public CommandShow(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.show();
    }
}
