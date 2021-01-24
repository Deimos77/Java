package Stuff;

import Exception.NoNameException;

public abstract class AEverything {
    private String Name;
    public static int NumberOfCreature;
    public AEverything(String name,String place){
        this.Name="\""+ name+"\"" ;
    }
    public int hashCode() {
        int hcode = Math.abs(this.getName().hashCode());
        return hcode;
    }
    public String getName() {
        try {
            if (this.Name=="") throw new IllegalArgumentException("Не указано имя");
            else return this.Name;
        }
        catch (NoNameException e) {
            return e.getException();
        }
    }
    public String toString() {
        return this.Name+" id["+this.hashCode()+"]"+", CreatureNumber["+NumberOfCreature+"].";
    }

}
