package ua.home.test;

import ua.home.model.User;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 30.08.2016.
 */
public class TestS {

    public static void main(String args[]){
        long a, b, c;
        BigInteger d, e, f;
        a = 9223372036854775807l;
        b = a;
        c = a * b;

        d = BigInteger.valueOf(a);
        e = BigInteger.valueOf(b);
        f = d.multiply(e);

        System.out.println("(long) " + a + " * " + b + " = " + c);
        System.out.println("(BigInteger) " + d.toString() + " * " + e.toString() + " = " + f.toString());

    }
}
