package week3.ex_download;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex_downloader {

    public static String downAddress(String url) throws IOException {

        Document document = Jsoup.connect(url).get();

        //Document doc = Jsoup.parse(document.outerHtml());

        Element link = document.select("a").first();



        String linkHref = link.attr("href");

        return linkHref;
    }



}
