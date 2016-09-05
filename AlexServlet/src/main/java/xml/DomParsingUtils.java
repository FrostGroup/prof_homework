package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Alex on 31.08.2016.
 */
public class DomParsingUtils {



    public static void parse (String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new File(path));

        Element root = document.getDocumentElement();

        System.out.printf("root %s, att %s\n", root.getTagName(), root.getAttribute("id"));

        NodeList nodeList = root.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element el = (Element) node;
                System.out.println(el);
            }else if(node.getNodeType() == Node.TEXT_NODE){

            }

        }

        System.out.println(" size " + nodeList.getLength());

    }

    public static String parseSom(Element root){
        root.getTagName();

        return null;
    }

}
