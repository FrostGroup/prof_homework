package week3.aliexpres.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import week3.aliexpres.model.Phone;

import java.io.IOException;

public class AliServiceImpl implements AliService {

    @Override
    public Phone getInfo(String url) throws IOException {

        Phone phone = new Phone();
        Document document = Jsoup.connect(url).get();
        Element prName = document.select("body > div.container > div:nth-child(3) > div.content > div:nth-child(1) > div.center_part > div.product_descr > h1").first();
        String productName = prName.text();

        Elements prPrice = document.select("body > div.container > div:nth-child(3) > div.content > div:nth-child(1) > div.center_part >" +
                " div.product_descr > div.frame_block_place > div:nth-child(1) > div.price > t");
        String productPrice = prPrice.text();

        phone.setPrise(productPrice);
        phone.setModel(productName);

        return phone;

    }
}
