package testProg;


import strim.NetUtils;
import week3.ex_download.Ex_downloader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String a = "http://www.nastol.com.ua/beautiful/175973-foto-pod-vodoj-avstriya-zelenoe-ozero-dajving-krasivo-potop.html";
        String b ="#body_element > table.list > tbody > tr:nth-child(2) > td.small > p:nth-child(3) > span:nth-child(3) > a";
        //NetUtils.load(a,b);


        System.out.print( Ex_downloader.downAddress(a));

    }
}
