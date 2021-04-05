package Commands;

import java.util.Scanner;

public interface Command {
    void execute(String argument, Scanner reader);
//    String getName();
}
