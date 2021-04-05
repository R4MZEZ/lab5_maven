package Client;

public class
Main {
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
        }
    }

}