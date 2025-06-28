import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;    //'X' 카운트

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'X') {
                cnt++;
            } else {  //'.'일 때
                if (cnt > 0) {
                    if (cnt % 2 == 0) { //짝수라면
                        while (cnt > 0) {
                            if (cnt >= 4) {
                                sb.append("AAAA");
                                cnt -= 4;
                            } else if (cnt >= 2) {
                                sb.append("BB");
                                cnt -= 2;
                            }
                        }
                    } else {
                        System.out.println(-1);
                        return;
                    }
                }
                sb.append(".");
                cnt = 0;    //초기화
            }
        }
        //남은 Cnt
        if (cnt % 2 == 0) {
            while (cnt > 0) {
                if (cnt >= 4) {
                    sb.append("AAAA");
                    cnt -= 4;
                } else if (cnt >= 2) {
                    sb.append("BB");
                    cnt -= 2;
                }
            }
        }
        else {
            System.out.println(-1);
            return;
        }
        System.out.println(sb.toString());


    }
}