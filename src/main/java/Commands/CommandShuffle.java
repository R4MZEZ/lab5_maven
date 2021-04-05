package Commands;

import Server.CollectionManager;

import java.util.Scanner;

public class CommandShuffle implements Command{

    CollectionManager manager;

    public CommandShuffle(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.shuffle();
    }
}
