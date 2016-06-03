package week3.ex_download;


import org.apache.log4j.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(Ex_downloader.class);

    public static String downAddress(String url) throws IOException {
        LOGGER.info("Try download address");
        Document document = Jsoup.connect(url).get();

        Element link = document.select("a").first();

        String linkHref = link.attr("href");

        return linkHref;
    }



}
