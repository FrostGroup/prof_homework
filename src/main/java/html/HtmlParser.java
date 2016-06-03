package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 31.05.2016.
 */
public class HtmlParser {
    public static void main(String[] args) throws IOException {

        List<String> linksList = new ArrayList<>();

        Document document = Jsoup.parse(new URL("http://www.ex.ua/101392258?r=904,23777"),1000);
        Element el = document.body();
        Elements elements = el.getElementsByTag("a");
        for (Element element : elements) {
            String href = element.attr("href");
            if(href.contains("/load")){
                linksList.add(href);
            }
        }
        linksList.stream().forEach(System.out::println);
    }
}
