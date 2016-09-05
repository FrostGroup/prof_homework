package xml.test;

import xml.utils.NetUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Alex on 02.09.2016.
 */
public class TestNetUtils {
    private static final String URL ="http://www.ex.ua/8105842?r=3";
    private static final String PATH = "D:/Development/" + "video";
    public static void main(String[] args) throws IOException, URISyntaxException {
        NetUtils.load(URL, PATH);
    }
}
