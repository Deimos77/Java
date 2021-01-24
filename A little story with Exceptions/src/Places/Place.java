package Places;
import Stuff.AEverything;
public class Place extends AEverything {

    public Place(String name,String place) {
        super(name, place);
        ++AEverything.NumberOfCreature;
        System.out.println("В объектной модели "+place+" Создано место "+this.toString());
    }

}
