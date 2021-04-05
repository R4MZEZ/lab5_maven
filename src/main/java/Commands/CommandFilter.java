package Commands;

import Server.CollectionManager;

import java.util.Scanner;

public class CommandFilter implements Command{

    CollectionManager manager;

    public CommandFilter(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        manager.filter_less_than_view(argument);
    }
}
