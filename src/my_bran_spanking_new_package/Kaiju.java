package my_bran_spanking_new_package;

import java.util.LinkedList;

public class Kaiju extends my_bran_spanking_new_package.Lebewesen {
    public Kaiju(String name, int alter) {
        super(name, alter);
    }
    public String to_String(){
        return (this.name + " is a kaiju that is " + this.alter + " years old.");
    }
    @Override
    public LinkedList<String> eierlegen() {
        LinkedList<String> eier = new LinkedList<>();
        eier.add("grünes Ei");
        eier.add("bläuliches Ei");
        eier.add("beiges Ei");
        return eier;
    }
}
