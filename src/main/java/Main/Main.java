package Main;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class Main {
    /**
     * @author Kazachenko Roman 312515
     */
    public static void main(String[] args) {
        try {
            Commander commander = new Commander(args[0]);
            commander.interactiveMod(System.in);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка. Отсутствует аргумент входного файла.");
            Commander commander = new Commander();
            commander.interactiveMod(System.in);
        } catch (JAXBException e) {
            System.out.println("Ошибка при десериализации документа. Проверьте правильность разметки.");
            Commander commander = new Commander();
            commander.interactiveMod(System.in);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл с входными данными не найден, проверьте путь и права доступа к файлу.");
            Commander commander = new Commander();
            commander.interactiveMod(System.in);
        }
    }

}
