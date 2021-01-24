package Enums;

public enum StuffName {
    Glasses("Очки"),
    Glass("Стакан с водой"),
    Jaws("Челюсти мамочки"),
    MarmaladePocket("Кулёк с мармеладками"),
    BedTable("Тумбочка"),


    ;
    private String title;
    StuffName(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }
}
