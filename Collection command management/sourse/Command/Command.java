package Command;

import java.io.IOException;

/**
 * Интерфейс для всех классов-команд.
 * @version 1.00
 * @author Deimos
 */
public interface Command {

    /**
     * Метод для реализации выполнения команды.
     * @param arg аргумент, используемый командой
     */
    void execute(String arg) throws IOException;

}
