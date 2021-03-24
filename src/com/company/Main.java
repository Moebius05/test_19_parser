package com.company;

import my_bran_spanking_new_package.ConsoleOutputContentHandler;
import my_bran_spanking_new_package.Kaiju;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        new DOM_parser();
        LinkedList<Kaiju> kaijuLinkedList = DOM_parser.pars_DOM("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");
        for (Kaiju x : kaijuLinkedList) {
            System.out.println(x.to_String());
        }
    }
}