package xml.test;

import org.xml.sax.SAXException;
import xml.DomParsingUtils;
import xml.utils.NetUtils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Alex on 02.09.2016.
 */
public class TestSome {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, URISyntaxException {
        List<String> list = NetUtils.findLoadURL("http://www.ex.ua/8105842?r=3");
        for (int i = 0; i < 5; i++) {
            NetUtils.load("http://www.ex.ua" + list.get(i), "D:/Development/audio" + i + ".mp3");
            System.out.println(i);
        }

    }
}
