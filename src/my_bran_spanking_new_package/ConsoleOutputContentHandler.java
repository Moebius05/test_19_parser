package my_bran_spanking_new_package;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConsoleOutputContentHandler extends DefaultHandler {
    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes atts) throws SAXException {
        System.out.println("start of element " + qName);
        printAttributes(atts);
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        System.out.println("end of element: " + qName);
    }

    protected void printAttributes(final Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println(attributes.getLocalName(i) + "=" + attributes.getValue(i));
        }
    }
}
