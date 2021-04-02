package Commands;

import Main.CollectionManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandExecuteScript implements Command{

    CollectionManager manager;

    public CommandExecuteScript(CollectionManager manager) {
        this.manager = manager;
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
