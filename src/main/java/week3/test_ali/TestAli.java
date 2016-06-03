package week3.test_ali;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import week3.aliexpres.model.Phone;
import week3.aliexpres.service.AliServiceImpl;

import java.io.IOException;

public class TestAli {

    public static void main(String[] args) throws IOException {

        String url = "http://www.foxtrot.com.ua/ru/shop/mobilnye_telefony_lenovo_a6010-pro-dual-sim-black.html";
        Phone phone = new AliServiceImpl().getInfo(url);
        System.out.println(phone.getModel());
        System.out.println(phone.getPrise());
    }

}
