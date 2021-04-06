package Client;

import Commands.*;
import java.io.*;
import java.util.Scanner;

/**
 * Класс, обеспечивающий обработку пользовательских команд
 */
public class Commander {

    Invoker invoker = new Invoker();
    Client.Connector connector = new Client.Connector();
    Thread connectorThread;

    public Commander(String filePath){
        connectorThread = new Thread(connector);
        connectorThread.start();
        System.out.println("Отправка входного файла..");
        connector.send(filePath);

        invoker.register("help", new CommandHelp());
        invoker.register("info", new CommandInfo());
        invoker.register("show", new CommandShow());
        invoker.register("remove_by_id", new CommandRemoveById());
        invoker.register("add", new CommandAdd());
        invoker.register("update", new CommandUpdate());
        invoker.register("clear", new CommandClear());
        invoker.register("execute_script", new CommandExecuteScript());
//        invoker.register("save", new CommandSave());
        invoker.register("remove_at", new CommandRemoveAt());
        invoker.register("remove_last", new CommandRemoveLast());
        invoker.register("shuffle", new CommandShuffle());
        invoker.register("average_of_living_space", new CommandAverage());
        invoker.register("max_by_house", new CommandMaxByHouse());
        invoker.register("filter_less_than_view", new CommandFilter());
        invoker.register("exit", new CommandExit());
    }

    public Commander() {
    }

    /**
     * Включить интерактивный режим
     * @param stream : поток ввода
     */
    public void interactiveMod(InputStream stream) {
        String fullUserCommand = "";
        if (stream.equals(System.in))System.out.println("***\tНачало работы. Для просмотра доступных команд напишите 'help'\t***");
        try (Scanner commandReader = new Scanner(stream)) {
            while (!fullUserCommand.equals("exit") && commandReader.hasNext()) {
                fullUserCommand = commandReader.nextLine();
                String[] command = fullUserCommand.trim().split(" ");
                if (invoker.contains(command[0])) {
                    try {
                        if (invoker.validate(command[0], command[1], commandReader)) {
                            connector.send(invoker.getCommandMap().get(command[0]));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        if (invoker.validate(command[0], "null", commandReader)) {
                            connector.send(invoker.getCommandMap().get(command[0]));
                        }
                    }
                }else System.out.println("Неопознанная команда! Введите 'help' для просмотра доступных команд.");

            }
        }
        System.out.println("***\tВыход из интерактивного режима\t***");
        Connector.isExit = true;
    }
}
