package Main;

import content.Flat;
import content.House;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Класс, обеспечивающий обработку пользовательских команд
 */
public class Commander {

    private static final Set<String> pathList = new HashSet<>();
    private CollectionManager manager = new CollectionManager();
    private String fullUserCommand = "";

    BufferedInputStream stream;
    JAXBContext context;
    Unmarshaller unmarshaller;

    public Commander(String filePath) throws JAXBException, FileNotFoundException {
        context = JAXBContext.newInstance(Flat.class, CollectionManager.class, House.class);
        unmarshaller = context.createUnmarshaller();
        stream = new BufferedInputStream(new FileInputStream(filePath));
        try {
            this.manager = (CollectionManager) unmarshaller.unmarshal(stream);
            Iterator<Flat> iterator = manager.getFlats().listIterator();
            while (iterator.hasNext()){
                if (iterator.next().isEmpty()){
                    System.out.println("Ошибка! Одна из квартир не была добавлена в коллекцию, т.к. одно или несколько полей не были указаны, либо выходят за допустимый диапазон.");
                    iterator.remove();
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Ошибка! Невозможно считать коллекцию из файла, т.к. одно или несколько полей указаны в некорректном формате (например, на месте числа - строка).");
        }

    }

    public Commander() {
    }

    /**
     * Включить интерактивный режим
     * @param stream : поток ввода
     */
    public void interactiveMod(InputStream stream) {
        if (stream.equals(System.in))System.out.println("***\tНачало работы. Для просмотра доступных команд напишите 'help'\t***");
        try (Scanner commandReader = new Scanner(stream)) {
            while (!fullUserCommand.equals("exit") && commandReader.hasNext()) {
                fullUserCommand = commandReader.nextLine();
                String[] command = fullUserCommand.trim().split(" ");
                try {
                    switch (command[0]) {
                        case "":
                            break;
                        case "help":
                            manager.help();
                            break;
                        case "info":
                            manager.info();
                            break;
                        case "show":
                            manager.show();
                            break;
                        case "add":
                            manager.add(commandReader);
                            break;
                        case "update":
                            manager.update(command[1], commandReader);
                            break;
                        case "remove_by_id":
                            manager.remove_by_id(command[1]);
                            break;
                        case "clear":
                            manager.clear();
                            break;
                        case "save":
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
                            break;
                        case "execute_script":
                            if (stream.equals(System.in)){
                                pathList.clear();
                            } else {
                                if (pathList.contains(command[1])){
                                    System.out.println("#############################################\nОшибка! Один или несколько скриптов зациклены.\n#############################################");
                                    break;
                                }
                            }  //Проверка на зацикленность
                            pathList.add(command[1]);
                            System.out.println("====  Начало выполнения скрипта по адресу " + command[1] + "  ====");
                            interactiveMod(new BufferedInputStream(new FileInputStream(command[1])));
                            System.out.println("====  Скрипт " + command[1] + " успешно выполнен  ====\n");
                            pathList.remove(command[1]);
                            break;
                        case "remove_at":
                            manager.remove_at(command[1]);
                            break;
                        case "remove_last":
                            manager.remove_last();
                            System.out.println("Последний элемент успешно удалён.");
                            break;
                        case "shuffle":
                            manager.shuffle();
                            break;
                        case "average_of_living_space":
                            manager.average_of_living_space();
                            break;
                        case "max_by_house":
                            manager.max_by_house();
                            break;
                        case "filter_less_than_view":
                            manager.filter_less_than_view(command[1]);
                            break;
                        default:
                            if (!fullUserCommand.equals("exit")) {
                                System.out.println("Неопознанная команда. Наберите 'help' для справки.");
                            } else System.out.println("***\tВыход из интерактивного режима\t***");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Отсутствует аргумент.");
                } catch (FileNotFoundException e){
                    System.out.println("Файл для извлечения скрипта не найден. Проверьте путь и права доступа к файлу.");
                }
            }
        }
    }
}
