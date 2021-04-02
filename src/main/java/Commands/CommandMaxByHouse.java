package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandMaxByHouse implements Command{

    CollectionManager manager;

    public CommandMaxByHouse(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.max_by_house();
    }
}
