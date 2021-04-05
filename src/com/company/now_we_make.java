package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class now_we_make {

    public static Node a_kaiju(String name, int alter) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus_zwischenlager.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf(//"<?xml version = \"1.0\"?>\n" + //+ id="Sebumsti"
                "<root>\n" +
                        "<kaiju>\n" +
                        "<name>" + name + "</name>\n" +
                        "<alter>" + alter + "</alter>\n" +
                        "</kaiju>" +
                        "</root>");
        printWriter.close();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document docc = null;
        try {
            docc = db.parse("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus_zwischenlager.xml");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        assert docc != null;
        docc.normalize();
        Node node = docc.getDocumentElement();

        if (node == null) {
            throw new IllegalArgumentException("node is null.");
        }
        return node;
    }
}