package Client;

import Commands.*;
import java.io.*;
import java.util.Scanner;

/**
 * Класс, обеспечивающий обработку пользовательских команд
 */
public class Commander {

    Invoker invoker = new Invoker();
    BufferedInputStream stream;
    Client.Connector connector = new Client.Connector();


    public Commander(String filePath){
//        CollectionManager manager = new CollectionManager();
        System.out.println("Отправка входного файла..");
        connector.send(filePath);
        System.out.println("Файл отправлен, ожидание ответа...");
        System.out.println(connector.receive());
        System.out.println("Ответ получен");
//        manager.setCommander(this);

//        invoker.register("help", new CommandHelp(manager));
//        invoker.register("info", new CommandInfo(manager));
//        invoker.register("show", new CommandShow(manager));
//        invoker.register("remove_by_id", new CommandRemoveById(manager));
//        invoker.register("add", new CommandAdd(manager));
//        invoker.register("update", new CommandUpdate(manager));
//        invoker.register("clear", new CommandClear(manager));
//        invoker.register("execute_script", new CommandExecuteScript(manager));
////        invoker.register("save", new CommandSave(manager));
//        invoker.register("remove_at", new CommandRemoveAt(manager));
//        invoker.register("remove_last", new CommandRemoveLast(manager));
//        invoker.register("shuffle", new CommandShuffle(manager));
//        invoker.register("average_of_living_space", new CommandAverage(manager));
//        invoker.register("max_by_house", new CommandMaxByHouse(manager));
//        invoker.register("filter_less_than_view", new CommandFilter(manager));
//        invoker.register("exit", new CommandExit(manager));
    }

    public Commander() {
    }

    public BufferedInputStream getStream() {
        return stream;
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

                        invoker.execute(command[0], command[1], commandReader);
//                    switch (command[0]) {
//                        case "":
//                            break;
//                        case "help":
//                            Command helpCommand = new CommandHelp(manager);
//                            invoker.register("help", helpCommand);
//                            invoker.execute("help");
//                            break;
//                        case "info":
//                            Command infoCommand = new CommandInfo(manager);
//
//                            invoker.execute("info");
//                            break;
//                        case "show":
//                            invoker.execute("show");
//                            break;
//                        case "add":
//                            manager.add(commandReader);
//                            break;
//                        case "update":
//                            manager.update(command[1], commandReader);
//                            break;
//                        case "remove_by_id":
//                            invoker.execute("");
//                            break;
//                        case "clear":
//                            manager.clear();
//                            break;
//                        case "save":
//                            try {
//                                manager.save(manager);
//                            } catch (FileNotFoundException e) {
//                                System.out.println("Ошибка. Файл не найден, проверьте пусть и доступ к файлу.");
//                            } catch (IOException e) {
//                                System.out.println("Ошибка сохранения.");
//                            } catch (MarshalException e) {
//                                System.out.println("Ошибка сериализации коллекции в XML.");
//                            } catch (JAXBException e) {
//                                e.printStackTrace();
//                            }
//                            break;
//                        case "execute_script":
//                            if (stream.equals(System.in)){
//                                pathList.clear();
//                            } else {
//                                if (pathList.contains(command[1])){
//                                    System.out.println("#############################################\nОшибка! Один или несколько скриптов зациклены.\n#############################################");
//                                    break;
//                                }
//                            }  //Проверка на зацикленность
//                            pathList.add(command[1]);
//                            System.out.println("====  Начало выполнения скрипта по адресу " + command[1] + "  ====");
//                            interactiveMod(new BufferedInputStream(new FileInputStream(command[1])));
//                            System.out.println("====  Скрипт " + command[1] + " успешно выполнен  ====\n");
//                            pathList.remove(command[1]);
//                            break;
//                        case "remove_at":
//                            manager.remove_at(command[1]);
//                            break;
//                        case "remove_last":
//                            manager.remove_last();
//                            System.out.println("Последний элемент успешно удалён.");
//                            break;
//                        case "shuffle":
//                            manager.shuffle();
//                            break;
//                        case "average_of_living_space":
//                            manager.average_of_living_space();
//                            break;
//                        case "max_by_house":
//                            manager.max_by_house();
//                            break;
//                        case "filter_less_than_view":
//                            manager.filter_less_than_view(command[1]);
//                            break;
//                        default:
//                            if (!fullUserCommand.equals("exit")) {
//                                System.out.println("Неопознанная команда. Наберите 'help' для справки.");
//                            } else System.out.println("***\tВыход из интерактивного режима\t***");
//                    }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        invoker.execute(command[0], "null", commandReader);
                    }
                }else System.out.println("Неопознанная команда! Введите 'help' для просмотра доступных команд.");

            }
        }
    }
}
