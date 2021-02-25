package content;

import java.util.Arrays;

/**
 * Класс для хранения видов из окна квартиры
 */
public enum View {
    YARD,
    BAD,
    NORMAL,
    GOOD,
    TERRIBLE;

    public static void ViewToString(){
        System.out.println("Список возможных видов из окна: " + Arrays.toString(View.values()));
    }
}