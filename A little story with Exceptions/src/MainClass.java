import Enums.StuffName;
import Exception.WrongArgumentException;
import Interfaces.*;
import Men.*;
import Places.*;
import Stuff.*;

public class MainClass {
    public static void main(String[] args) {
        Place flat = new Place("Дом","\"Мир\"");
        HumanAble someone = new Human("Неизвестный объект женского рода",flat.getName());
        someone.leave(flat.getName());
        HumanAble LilBoy = new Human("Малыш", flat.getName());

        //АНОНИМНЫЙ КЛАСС НИЖЕ, в нём переопределяется метод вот этот с длинным названием, анонимный класс тут подходит как нельзя кстати, тк нет необходимости давать имя этому изменению.
        HumanAble uncle = new Human("Дядя Юлиус",flat.getName()) {
            public void tryingToUnderstandHowHeGetHere(String s) {
                System.out.println("Обьект "+ this.getName() +" докапывается до обьекта "+ s +",о том,как он попал сюда.");
            }
        };
        //ЗАКОНЧИЛСЯ АНОНИМНЫЙ КЛАСС

        StuffAble Jaws = new Stuff(StuffName.Jaws.getTitle(),flat.getName());
        LilBoy.take(StuffName.Jaws);
        LilBoy.understand();
        LilBoy.runAndWakeUp(((AEverything) uncle).getName());
        Place bedRoom = new Place("Спальня",flat.getName());
        NatureAble sound = new Nature("Звук",bedRoom.getName());
        sound.playSound("грр-пс-пс");

        uncle.sleepAsAChild();
        NatureAble DayOfTime = new Nature("Свет","Мир");
        DayOfTime.gettingLight();
        DayOfTime.stillDark();

        StuffAble BedTable  = new Stuff(StuffName.BedTable.getTitle(),bedRoom.getName());
        StuffAble Glass = new Stuff(StuffName.Glass.getTitle(),bedRoom.getName());
        LilBoy.lookAround(StuffName.Glass);

        LilBoy.lowable(StuffName.Jaws,StuffName.Glass);
        sound.playSound("Тихий плеск");
        StuffAble Glasses = new Stuff(StuffName.Glasses.getTitle(),bedRoom.getName());
        StuffAble Marmelade = new Stuff(StuffName.MarmaladePocket.getTitle(),bedRoom.getName());

        // ОБРАБАТЫВАЕМ ОШИБКУ ТРАЙ КОТЧЕМ НИЖЕ, тк мы подбросили(throws) обработку этой ошибку на уровень выше из класс Stuff.
        try {
            Glasses.lay(1);
            Marmelade.lay(6);
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }

        ClothAble Pijama = new Clothes("Пижама",bedRoom.getName());
        Pijama.createPartOfClothes("Карман");
        LilBoy.take(StuffName.MarmaladePocket);
        LilBoy.putIn(StuffName.MarmaladePocket,"Карман");
        LilBoy.want(StuffName.MarmaladePocket);
        if (Human.LilBoyWasSeenByUncle==false) {
            System.out.print("Если бы Дядя увидел Малыша, тогда выполнилось бы следующее действие: ");
            uncle.tryingToUnderstandHowHeGetHere(((AEverything)LilBoy).getName());
        }
        Stuff.UncleStuff stuff = new Stuff.UncleStuff();
        LilBoy.disregarding();
        LilBoy.startADeal((Human) uncle);
    }
}
