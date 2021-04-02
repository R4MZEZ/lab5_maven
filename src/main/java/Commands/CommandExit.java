package Commands;

import Main.CollectionManager;

import java.util.Scanner;

public class CommandExit implements Command{

    CollectionManager manager;

    public CommandExit(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        System.out.println("***\tВыход из интерактивного режима\t***");
    }
}
