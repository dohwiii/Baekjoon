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
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int numCheck = 0;

        for (String str : arr) {
            char[] temp = str.toCharArray();
            sb.setLength(0);
            numCheck = 0;
            for (int i = 0; i < temp.length; i++) {
                if (Character.isDigit(temp[i])) {
                    if (temp[i] != '0') {
                        numCheck++;
                    }
                    sb.append(temp[i]);
                }
                else {  //알파벳이라면
                    if (sb.length() > 0) {
                        if (numCheck == 0) {
                            list.add("0");
                        }
                        else {
                            int index = -1;
                            for (int j = 0; j < sb.length(); j++) {
                                if (sb.charAt(j) != '0') {
                                    index = j;
                                    break;
                                }
                            }
                            if (index >= 0) {
                                list.add(sb.substring(index));
                            }
                        }
                    }
                    sb.setLength(0);    //초기화
                    numCheck = 0;
                }
            }
            if (sb.length() > 0) {
                if (numCheck == 0) {
                    list.add("0");
                }
                else {
                    int index = -1;
                    for (int j = 0; j < sb.length(); j++) {
                        if (sb.charAt(j) != '0') {
                            index = j;
                            break;
                        }
                    }
                    if (index >= 0) {
                        list.add(sb.substring(index));
                    }
                }
            }

        }
        list.sort((s1, s2) ->
                new BigInteger(s1).compareTo(new BigInteger(s2))
        );
        sb.setLength(0);

        for (String a : list) {
            sb.append(a + "\n");
        }
        System.out.println(sb);

    }

}