package com.company;

import my_bran_spanking_new_package.Kaiju;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class Java_STAX_parser {
    public LinkedList<Kaiju> parse(String pfad) {
        boolean ist_kaiju = false;
        boolean kaiju_hat_name = false;
        String kaiju_namen = ".";
        boolean kaiju_hat_alter = false;
        int kaiju_alter = 0;
        int kaiju_count = 0;
        LinkedList<Kaiju> aussi = new LinkedList<>();
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(pfad));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("... ...");
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equals("kaiju")) {
                            ist_kaiju = true;
                        } else if (qName.equals("name") && ist_kaiju) {
                            kaiju_hat_name = true;
                        } else if (qName.equals("alter") && ist_kaiju) {
                            kaiju_hat_alter = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (kaiju_hat_name) {
                            kaiju_namen = characters.getData();
                            kaiju_hat_name = false;
                        }
                        if (kaiju_hat_alter) {
                            kaiju_alter = Integer.parseInt(characters.getData());
                            kaiju_hat_alter = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if (endElement.getName().getLocalPart().equals("kaiju")) {
                            aussi.add(new Kaiju(kaiju_namen, kaiju_alter));
                            System.out.println("Kaiju number " + ++kaiju_count + " is here.");
                            ist_kaiju = false;
                        }
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return aussi;
    }
}