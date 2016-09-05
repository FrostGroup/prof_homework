package xml.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.html.parser.Parser;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 01.09.2016.
 */
public class NetUtils {

    public static void load(String url, String dest) throws URISyntaxException, IOException {
        try ( InputStream is = new URI(url).toURL().openStream();
              OutputStream os = new FileOutputStream(dest)) {

            byte[] buff = new byte[1024];
            int count = 0;
            while ((count = is.read(buff)) != -1) {
                os.write(buff, 0, count);
                os.flush();
            }
        }
    }

    public static List<String> findLoadURL(String url) throws URISyntaxException, IOException {
        List<String> list = new ArrayList<>();
        Document document = Jsoup.parse(new URL(url), 10000);
        Element el = document.body();
        Elements elements = el.getElementsByTag("a");

        for (int i = 0; i < elements.size(); i++) {
            String str = elements.get(i).attr("href");
            if(str.contains("/load") && !str.contains("id")){
                list.add(str);
            }
        }
        return list;
    }
}
