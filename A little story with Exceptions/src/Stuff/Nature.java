package Stuff;

import Interfaces.NatureAble;

public class Nature extends AEverything implements NatureAble {
    String Place;
    public Nature(String name,String place) {
        super(name,place);
        this.Place = place;
    }

    @Override
    public void playSound(String sound) {
        class Sound{
            Sound(String s){
                System.out.println("В месте "+Place+" производится звук: \""+s+"\".");
            }
        }
        Sound sound1 = new Sound(sound);

    }

    @Override
    public void gettingLight() {
        System.out.println("В мире начало светать.");

    }

    @Override
    public void stillDark() {
        System.out.println("Но были ещё сумерки.");

    }


}
