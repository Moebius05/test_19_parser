package my_bran_spanking_new_package;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;

//for SAXPARSERDEMO
class Kaijubehandler extends DefaultHandler {
    boolean name = false;
    String kaiju_name = "";
    boolean alter = false;
    int kaiju_alter = 0;
    String des_aktuellen_Knotens_name = "";
    private final LinkedList<Kaiju> kaijuLinkedList = new LinkedList<>();

    @Override
    public void endDocument() {
        System.out.println(des_aktuellen_Knotens_name);
    }

    public String endDocument(int eini) {
        for (int i = 0; i < eini; i++) {
            System.out.println("That's all folks!");
        }
        return "sans aucun sens";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("name")) {
            name = true;
        } else if (qName.equalsIgnoreCase("alter")) {
            alter = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        des_aktuellen_Knotens_name = new String(ch, start, length);
        if (name) {
            kaiju_name = new String(ch, start, length);
            name = false;
        } else if (alter) {
            kaiju_alter = Integer.parseInt(new String(ch, start, length));
            alter = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("kaiju")) {
            kaijuLinkedList.add(new Kaiju(kaiju_name, kaiju_alter));
        } else if ((qName.equalsIgnoreCase("name")) || (qName.equalsIgnoreCase("alter"))) {
            System.out.println(" . ");
        } else {
            System.out.println("...");
        }
    }

    public LinkedList<Kaiju> getKaijuLinkedList() {
        return kaijuLinkedList;
    }
}