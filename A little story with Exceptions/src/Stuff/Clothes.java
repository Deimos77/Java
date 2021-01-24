package Stuff;

import Interfaces.ClothAble;

public class Clothes extends Stuff implements ClothAble {
    protected String ClothName;
    public Clothes(String name,String place) {
        super(name,place);
        this.ClothName = name;
    }
    //Вложенный нон статик класс, тк часть одежды лучше запихнуть в саму одежду,а не создавать отдельную сущность под неё.
    public class PartOfCloth {
        public PartOfCloth(String name) {
            System.out.println("Создана часть одежды \""+ClothName+"\" ---> \""+ name+"\".");
        }

    }

    @Override
    public void createPartOfClothes(String part) {
        PartOfCloth part1 = new PartOfCloth(part);
    }

}
