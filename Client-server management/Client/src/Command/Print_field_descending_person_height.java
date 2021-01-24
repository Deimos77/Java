package Command;

import Client.Invoker;

public class Print_field_descending_person_height implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Print_field_descending_person_height() {
        Invoker.regist("print_field_descending_person_height", this);
    }


    @Override
    public String execute(String arg) {

        return null;
    }
}
