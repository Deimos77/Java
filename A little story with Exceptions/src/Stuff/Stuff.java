package Stuff;

import Enums.StuffName;
import Exception.WrongArgumentException;
import Interfaces.StuffAble;

public class Stuff extends AEverything implements StuffAble{
    protected String Place;
    public Stuff(String name,String place) {
        super(name,place);
        this.Place =place;
        ++AEverything.NumberOfCreature;
        System.out.println("В месте "+place+ " создан предмет "+this.toString());
    }
    //Ниже ВЛОЖЕННЫЙ СТАТИК КЛАСС тут он уместнее,чем нон-статик, тк эт тип группа определённых вещей.
    public static class UncleStuff {
        public UncleStuff() {
            System.out.println("Созданы вещи дяди Юлиуса, но они не лежат на месте.");
        }
        Stuff wallet = new Stuff("Бумажник","Дом");
        Stuff watch = new Stuff("Часы","Дом");

    }
    @Override
    public void lay(int i) throws WrongArgumentException  { //Подбрасываем ошибку уровнем выше словом throws
        switch (i) {
            case 1:
                System.out.println("В месте "+this.Place+" рядом с предметом \""+ StuffName.Glass.getTitle()+"\" лежал предмет "+ this.getName()+".");
                break;
            case 2:
                System.out.println("В месте "+this.Place+" лежал предмет "+ this.getName()+".");
                break;
            default:
                throw new WrongArgumentException("НИПРАВИЛЪНАЯ ЦЕФОРКА");
                //В случае i не равно 1 и 2 выбросится ошибка
        }

    }

}
