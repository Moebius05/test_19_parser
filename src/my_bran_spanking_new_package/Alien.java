package my_bran_spanking_new_package;

import java.util.LinkedList;

public class Alien extends my_bran_spanking_new_package.Lebewesen {
    /**
     *  property of the Weyland Yutani cooperation
     *  */
    public Alien() {
        this("nameless",1000);
    }

    /** prooerty of the Weyland Yutani cooperation*/
    public Alien(String name, int alter) {
        super(name, alter);
    }

    public void die(){
        System.out.printf("The " + this.name + " cannot die.");
    }
    public LinkedList<String> eierlegen(){
        LinkedList<String> aussi =  new LinkedList<String>();
        return aussi;
    }
}
