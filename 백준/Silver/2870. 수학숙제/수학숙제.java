import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        List<BigInteger> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int numCheck = 0;

        for (String str : arr) {
            char[] temp = str.toCharArray();
            sb.setLength(0);
            numCheck = 0;
            for (int i = 0; i < temp.length; i++) {
                if (Character.isDigit(temp[i])) {
                    sb.append(temp[i]);
                    if (i == str.length() - 1) {
                        list.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
                else {  //알파벳이라면
                    if (sb.length() > 0) {
                        list.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }

        }
        Collections.sort(list);
        sb.setLength(0);

        for (BigInteger a : list) {
            sb.append(a + "\n");
        }
        System.out.println(sb);

    }

}