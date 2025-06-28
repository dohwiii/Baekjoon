import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            r.append("z");
        }
        String result = r.toString();
        for (int s = 1; s < input.length() - 2; s++) {
            for (int e = input.length() - 1; e > s; e--) {
                String front = input.substring(0, s);
                String middle = input.substring(s, e);
                String back = input.substring(e);

                sb.append(new StringBuilder(front).reverse())
                        .append(new StringBuilder(middle).reverse())
                        .append(new StringBuilder(back).reverse());

                String newStr = sb.toString();
                if (newStr.compareTo(result) < 0) {
                    result = newStr;
                }
                sb.setLength(0);
            }
        }

        System.out.println(result);

    }

}