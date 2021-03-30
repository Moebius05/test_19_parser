package my_bran_spanking_new_package;

import java.io.File;
import java.util.LinkedList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserDemo {
    public static LinkedList<Kaiju> parse_the_SAX(String pfadname) {
        LinkedList<Kaiju> kaijuHauptLinkedList = new LinkedList<>();
        try {
            File datei_mit_kaijus = new File(pfadname);
            SAXParserFactory meine_fabrik = SAXParserFactory.newInstance();
            SAXParser mein_SAXParser = meine_fabrik.newSAXParser();
            Kaijubehandler ich_behandle_Benutzer = new Kaijubehandler();
            mein_SAXParser.parse(datei_mit_kaijus, ich_behandle_Benutzer);
            kaijuHauptLinkedList = ich_behandle_Benutzer.getKaijuLinkedList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Kaiju kaiju : kaijuHauptLinkedList) {
            System.out.println(kaiju.to_String());
        }
        return kaijuHauptLinkedList;
    }
}