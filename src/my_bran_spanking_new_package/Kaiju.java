package my_bran_spanking_new_package;

import java.util.LinkedList;

public class Kaiju extends my_bran_spanking_new_package.Lebewesen {
    public Kaiju(String name, int alter) {
        super(name, alter);
    }

    @Override
    public LinkedList eierlegen() {
        LinkedList<String> eier = new LinkedList<>();
        eier.add("grünes Ei");
        eier.add("bläuliches Ei");
        eier.add("beiges Ei");
        return eier;
    }
}
