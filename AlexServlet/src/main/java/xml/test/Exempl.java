package xml.test;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


/**
 * Created by Alex on 05.09.2016.
 */
public class Exempl {

    public static void main(String args[]) throws Exception {

        String str = "111 2 111 22 111 4 fgfg 4 fggfgf 4 tt5 " +
                "2 kfjkj 5 5 5 hrghk ffgd fgdf 9 9 9 9 uvkfnd 3 6 8";
        String[] strRep = str.split(" ");

        Map<String, Integer> mapRep = new HashMap<>();

        for (String s : strRep) {
            if(mapRep.containsKey(s)) {
                int temp = mapRep.get(s);
                mapRep.put(s, ++temp);
            }else{
                mapRep.put(s, 1);
            }
        }
        List list = new ArrayList<>(mapRep.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        for (int i = list.size() - 6; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
