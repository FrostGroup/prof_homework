package xml;

import org.xml.sax.SAXException;
import xml.utils.NetUtils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Alex on 01.09.2016.
 */
public class RunDmParser {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, URISyntaxException {
        //DomParsingUtils.parse(Constants.PATH);
        NetUtils.load(Constants.PATH,"");


    }
}
