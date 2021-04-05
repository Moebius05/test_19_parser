package my_bran_spanking_new_package;

import java.util.LinkedList;

/**
 * life is all we are interested in
 */
abstract class Lebewesen {
    final String name;
    final int alter;

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public Lebewesen(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public void die(String eini) {
        System.out.println("The " + name + " has been killed by " + eini);
    }

    public abstract LinkedList<String> eierlegen();

}
