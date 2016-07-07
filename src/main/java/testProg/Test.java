package testProg;


import chat.client.ClientChat;
import chat.client.ClientChatRun;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import strim.NetUtils;
import week3.aliexpres.model.Phone;
import week3.ex_download.Ex_downloader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //String a = "http://www.nastol.com.ua/beautiful/175973-foto-pod-vodoj-avstriya-zelenoe-ozero-dajving-krasivo-potop.html";
        //String b ="#body_element > table.list > tbody > tr:nth-child(2) > td.small > p:nth-child(3) > span:nth-child(3) > a";
        //NetUtils.load(a,b);


        //System.out.print( Ex_downloader.downAddress(a));

        Phone phone = new Phone("LG","P900","17,50");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String sts = gson.toJson(phone);

        Phone phone1 = gson.fromJson(sts, Phone.class);

        System.out.println(phone.toString());
        System.out.println(phone1.toString());


        System.out.println(sts);

    }
}
