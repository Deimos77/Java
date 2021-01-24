package Men;

import Enums.StuffName;
import Interfaces.HumanAble;
import Stuff.AEverything;

public class Human extends AEverything implements HumanAble{
    protected String Place;
    public Human(String name,String place) {
        super(name, place);
        ++AEverything.NumberOfCreature;
        this.Place = place;
        System.out.println("В месте "+place+" Создан персонаж "+this.toString());
    }
    public static boolean LilBoyWasSeenByUncle;
    @Override
    public void sleepAsAChild() {
        System.out.println("Обьект "+ this.getName()+" спал как ребёнок в месте "+this.Place+".");

    }

    @Override
    public void lookAround(StuffName s) {
        System.out.println("Обьект "+this.getName()+" разглядел предмет \"" + s.getTitle() + "\" в месте "+this.Place+".");

    }

    @Override
    public void take(StuffName a) {
        System.out.println("Обьект "+this.getName()+" взял предмет \"" + a.getTitle() + "\".");
        LilBoyWasSeenByUncle = false;

    }

    @Override
    public void putIn(StuffName a,String s) {
        LilBoyWasSeenByUncle = false;
        System.out.println("Обьект "+this.getName()+" положил предмет \""+a.getTitle()+"\""+ " в предмет одежды \""+s+"\". \nДядя Юлиус увидел Малыша? - "+ LilBoyWasSeenByUncle  );

    }

    @Override
    public void lowable(StuffName a,StuffName b) {
        System.out.println("Обьект "+this.getName()+" опустил в предмет \""+b.getTitle() + "\" предмет \""+a.getTitle()+"\".");

    }

    @Override
    public void want(StuffName a) {
        System.out.println("Обьект "+this.getName()+" хочет отдать предмет \""+a.getTitle()+"\" Карлсону.");

    }


    @Override
    public void leave(String s) {
        System.out.println("Обьект "+this.getName()+" торопливо вышла из места "+s+".");

    }

    @Override
    public void runAndWakeUp(String s) {
        System.out.println("Объект "+this.getName()+ " побежал будить объект "+s+" .");

    }

    @Override
    public void understand() {
        System.out.println("Объект "+this.getName()+" понимает,что объект \""+StuffName.Jaws.getTitle()+"\" нужнее самому дяде Юлиусу.");

    }

    @Override
    public void strangeFeeling() {
        System.out.println("У объекта "+this.getName()+" возникло смутное ощущение,что на объекте \""+StuffName.BedTable.getTitle()+"\" должно ещё что-то лежать");
    }

    @Override
    public void tryingToUnderstandHowHeGetHere(String s) {

    }

    @Override
    public void disregarding() {
        System.out.println("Объект "+this.getName()+" не обратил на это особого внимания.");
    }

    @Override
    public void startADeal(Human s) {

        System.out.println("Объект "+this.getName()+" приступил к порученному делу - разбудить объект "+s.getName());
    }


}
