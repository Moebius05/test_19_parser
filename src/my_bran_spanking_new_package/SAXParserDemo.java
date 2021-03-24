package my_bran_spanking_new_package;

import java.io.File;
import java.util.LinkedList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {
    public static void main(String[] args) {
        LinkedList<Kaiju> kaijuHauptLinkedList = new LinkedList<>();
        try {
            File datei_mit_kaijus = new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");
            SAXParserFactory meine_fabrik = SAXParserFactory.newInstance();
            SAXParser mein_SAXParser = meine_fabrik.newSAXParser();
            Kaijubehandler ich_behandle_Benutzer = new Kaijubehandler();
            mein_SAXParser.parse(datei_mit_kaijus, ich_behandle_Benutzer);
            kaijuHauptLinkedList = ich_behandle_Benutzer.getKaijuLinkedList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < kaijuHauptLinkedList.size(); i++) {
            System.out.println(kaijuHauptLinkedList.get(i).to_String());
        }
    }
}

class Kaijubehandler extends DefaultHandler {
    boolean name = false;
    String kaiju_name = "";
    boolean alter = false;
    int kaiju_alter = 0;
    boolean extra = false;
    private LinkedList<Kaiju> kaijuLinkedList = new LinkedList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("kaiju")) {
        } else if (qName.equalsIgnoreCase("name")) {
            name = true;
        } else if (qName.equalsIgnoreCase("alter")) {
            alter = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (name) {
            kaiju_name = new String(ch, start, length);
            name = false;
        } else if (alter) {
            kaiju_alter = Integer.valueOf(new String(ch, start, length));
            alter = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("kaiju")) {
            kaijuLinkedList.add(new Kaiju(kaiju_name, kaiju_alter));
        }
    }

    public LinkedList<Kaiju> getKaijuLinkedList() {
        return kaijuLinkedList;
    }
}