package Commands;

import java.util.HashMap;
import java.util.Scanner;

public class Invoker {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public boolean contains(String commandName){
        return commandMap.containsKey(commandName);
    }

    public void execute(String commandName, String argument, Scanner reader) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("no command registered for " + commandName);
        }
        command.execute(argument, reader);
    }
}

