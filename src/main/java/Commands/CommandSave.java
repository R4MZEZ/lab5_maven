package Commands;

import Main.CollectionManager;

import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CommandSave implements Command{

    CollectionManager manager;

    public CommandSave(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String argument, Scanner reader) {
        try {
            manager.save(manager);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка. Файл не найден, проверьте пусть и доступ к файлу.");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения.");
        } catch (MarshalException e) {
            System.out.println("Ошибка сериализации коллекции в XML.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

