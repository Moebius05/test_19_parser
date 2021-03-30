package com.company;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Java_STAX_search {
    void search(String suchwort, String pfad) {
        boolean gefunden = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = factory.createXMLEventReader(new FileReader(pfad));
            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ((event.toString().length() > suchwort.length()) && (event.toString().startsWith(suchwort, 1))) {
                            System.out.print("\n\nGefunden:");
                            gefunden = true;
                        }
                        if (gefunden) {
                            System.out.print('\n' + event.toString().substring(1, event.toString().length() - 1) + ": \t");
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (event.isCharacters()) {
                            Characters characters = event.asCharacters();
                            if ((gefunden) && (characters.getData().trim().length() != 0)) {
                                System.out.print(characters.getData());
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (event.asEndElement().getName().getLocalPart().equals(suchwort)) {
                            gefunden = false;
                        }

                    default:
                        break;
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}