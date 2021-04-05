package my_bran_spanking_new_package;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class now_we_add {
    public static void a_kaiju(File File_eins, File File_zwei, File ziel) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document dokument_eins = null;
        Document dokument_zwei = null;

        try {
            documentBuilder = dbf.newDocumentBuilder();
            dokument_eins = documentBuilder.parse(File_eins);
            dokument_zwei = documentBuilder.parse(File_zwei);
            NodeList nodeList_Dokument_eins = dokument_eins.getElementsByTagName("wesen");
            Node node_contains_new_kaiju = dokument_eins.importNode(dokument_zwei.getElementsByTagName("kaiju").item(0), true);
            nodeList_Dokument_eins.item(0).appendChild(node_contains_new_kaiju);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource domSource = new DOMSource(dokument_eins);
            StreamResult streamResult = new StreamResult(new StringWriter());

            transformer.transform(domSource, streamResult);

            Writer output = new BufferedWriter(new FileWriter(ziel));
            String ergebnis = streamResult.getWriter().toString();

            output.write(ergebnis.trim());
            output.close();

        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
