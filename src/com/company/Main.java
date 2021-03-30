package com.company;

import my_bran_spanking_new_package.Kaiju;
import my_bran_spanking_new_package.SAXParserDemo;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        System.out.println("DOM parser");
        LinkedList<Kaiju> kaijuLinkedList = DOM_parser.pars_DOM("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");
        for (Kaiju x : kaijuLinkedList) {
            System.out.println(x.to_String());
        }

        System.out.println("SAX parser");
        SAXParserDemo.parse_the_SAX("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");

        Java_STAX_parser mein_java_stax_parser = new Java_STAX_parser();
        LinkedList<Kaiju> kaijuLinkedList1 = mein_java_stax_parser.parse("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");
        for (Kaiju kaiju : kaijuLinkedList1) {
            System.out.println(kaiju.to_String());
        }

        Java_STAX_search meine_Suche = new Java_STAX_search();
        meine_Suche.search("kaiju", "C:\\Users\\paulf\\IdeaProjects\\test_19\\out\\production\\test_19\\my_bran_spanking_new_package\\kaijus.xml");
    }
}