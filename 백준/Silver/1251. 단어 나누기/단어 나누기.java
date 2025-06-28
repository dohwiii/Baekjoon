import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int s = 1; s < input.length() - 2; s++) {
            for (int e = input.length() - 1; e > s; e--) {
                String front = input.substring(0, s);
                String middle = input.substring(s, e);
                String back = input.substring(e);

                sb.append(new StringBuilder(front).reverse())
                        .append(new StringBuilder(middle).reverse())
                        .append(new StringBuilder(back).reverse());

                list.add(sb.toString());
                sb.setLength(0);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));

    }

}