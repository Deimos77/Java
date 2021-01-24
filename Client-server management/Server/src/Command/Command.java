package Command;

import java.io.IOException;
import java.io.Serializable;

/**
 * Интерфейс для всех классов-команд.
 * @version 1.00
 * @author Deimos
 */
public interface Command extends Serializable {

    /**
     * Метод для реализации выполнения команды.
     * @param arg аргумент, используемый командой
     */
    String execute(String arg) throws IOException;


}
