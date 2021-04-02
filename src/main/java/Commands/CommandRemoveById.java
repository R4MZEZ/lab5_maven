package Commands;

import Main.Checker;
import Main.CollectionManager;

import java.util.Scanner;

public class CommandRemoveById implements Command{
    CollectionManager manager;

    public CommandRemoveById(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String id, Scanner reader) {
        manager.remove_by_id(id);
    }
}
