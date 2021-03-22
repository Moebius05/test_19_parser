package com.company;

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
        LinkedList<Kaiju> kaijuLinkedList = new LinkedList<>();
        File quelldatei = null;
        try {
            quelldatei = new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document docc = db.parse(quelldatei);
        docc.normalize();
        NodeList nodeList = docc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            if ((nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) &&
                    (nodeList.item(i).getNodeName().equals("kaiju"))) {
                NodeList kaiju_items = nodeList.item(i).getChildNodes();
                String name = "";
                int alter = 0;
                for (int j = 0; (j < kaiju_items.getLength()) && (!kaiju_items.item(j).getNodeName().equals("kaiju")); j++) {
                    if (kaiju_items.item(j).getNodeName().equals("name")) {
                        name = kaiju_items.item(j).getTextContent();
                    }
                    if (kaiju_items.item(j).getNodeName().equals("alter")) {
                        String bla = kaiju_items.item(j).getTextContent().trim();
                        alter = Integer.parseInt(bla);
                    }
                    if (!(name.equals("")) && (alter != 0)) {
                        Kaiju kaiju = new Kaiju(name, alter);
                        kaijuLinkedList.add(kaiju);
                        name = "";
                        alter = 0;
                    }
                }
            }
        }
        for (Kaiju x : kaijuLinkedList) {
            System.out.println(x.to_String());
        }
    }
}