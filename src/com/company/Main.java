package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.xml.transform.TransformerException;
import org.w3c.dom.NodeList;

public class Main {
    public static LinkedList<String> ute_Nacht = new LinkedList<>();

    public static void iterateNodes(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("i \t" + i);
            Node currentode = nodeList.item(i);
            System.out.println(currentode.getAttributes());
            System.out.println(currentode.getNodeValue());
            System.out.println(currentode.getNodeName());
            if (currentode.getNodeName() == "name") {
                ute_Nacht.add(currentode.getTextContent().trim());
            }
            if (currentode.getNodeName() == "alter") {
                ute_Nacht.add(currentode.getTextContent().trim());
            }
            if (currentode.hasChildNodes() == true) {
                Element element = (Element) currentode;
                iterateNodes(element);
            }

            if (currentode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) currentode;
                iterateNodes(element);
            }

        }
    }

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        File quelldatei = null;
        try {
            quelldatei = new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document docc = db.parse(quelldatei);
        docc.normalize();
        NodeList nodeList = docc.getElementsByTagName("*");
        System.out.println("........................");
        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength() && (true); i++) {
            System.out.println("Item " + i);
            System.out.println(nodeList.item(i));
            System.out.println("node type " + nodeList.item(i).getNodeType() + "   -->" + i);
            System.out.println(nodeList.item(i).getClass());
            System.out.println();
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            if ((nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) &&
                    (nodeList.item(i).getNodeName() == "kaiju")) {

                System.out.print("HIER! EIN TEXT_NODE!  " + i + "    ");
                System.out.println(nodeList.item(i).getNodeName());
                System.out.println(nodeList.item(i).getTextContent());
            }
        }
        // nodelist.item(1);
        //    NodeList nodeList = quelldatei.
//        Document document = docBuilder.parse(new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml"));
        //      Document documentF = docBuilder.parse(new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml"));

    }
}


/*        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Node node_2 = node.getFirstChild();
            Node node_3 = node.getLastChild();
            Kaiju kaiju = new Kaiju(node_2.getLocalName(), 99);
            kaijuLinkedList.add(kaiju);
            System.out.println("x");
            ;
        }
        for (int i = 0; i < kaijuLinkedList.size(); i++) {
            System.out.println(i);
            System.out.println(kaijuLinkedList.get(i).getName());
            System.out.println(kaijuLinkedList.get(i).getAlter());
        }

    }
}*/

        /*
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            String dieser_Name = "";
            int alter = 99;
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // do something with the current element
                System.out.println(node.getNodeName());
                if (node.getNodeName() == "name") {
                    dieser_Name = node.getTextContent();
                    System.out.println("dieser Name ist " + dieser_Name);
                }
                if (node.getNodeName() == "alter") {
                    System.out.println("dieser Name ist " + dieser_Name);
                    alter = Integer.valueOf(node.getTextContent());
                }
                Kaiju kaiju = new Kaiju(dieser_Name, alter);
                kaijuLinkedList.add(kaiju);
            }
        }
        for (int i = 0; i < kaijuLinkedList.size(); i++) {

            System.out.println(kaijuLinkedList.get(i).getName() + " ist " + kaijuLinkedList.get(i).getAlter() + " Jahre alt. ");
        }
        System.out.println(nodeList.toString());
        System.out.println(nodeList.getLength());
    }

    public static void doSomething(Node node) {
        // do something with the current node instead of System.out
        System.out.println(node.getNodeName());

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                //calls this method for all the children which is Element
                doSomething(currentNode);
            }
        }
    }
}*/