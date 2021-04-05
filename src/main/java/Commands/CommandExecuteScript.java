package Commands;

import Server.CollectionManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandExecuteScript implements Command{

    CollectionManager manager;
    final String name = "execute_script";
    String argument;

    public CommandExecuteScript(CollectionManager manager) {
        this.manager = manager;
    }

//    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(String argument, Scanner reader){
        try {
            manager.execute_script(argument);
        }catch (FileNotFoundException e){
            System.out.println("Файл для извлечения скрипта не найден. Проверьте путь и права доступа к файлу.");
        }
    }
}
