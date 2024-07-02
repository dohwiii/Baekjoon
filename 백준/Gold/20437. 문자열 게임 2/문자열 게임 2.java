import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());    //게임 진행 횟수

        for (int i = 0; i < T; i++) {
            Map<Character, Integer> cntHm = new HashMap<>();    //몇번 나왔는지 카운트

            String str = br.readLine();
            int len = str.length();
            int K = Integer.parseInt(br.readLine());
            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            for (int j = 0; j < str.length(); j++) {
                if (cntHm.containsKey(str.charAt(j))) {
                    cntHm.put(str.charAt(j), cntHm.get(str.charAt(j)) + 1);
                }
                else {
                    cntHm.put(str.charAt(j), 1);
                }
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < len; j++) {
                if (cntHm.get(str.charAt(j)) < K) {
                    continue;
                }
                int cnt = 1;
                for (int k = j + 1; k < len; k++) {
                    if (str.charAt(j) == str.charAt(k)) {
                        cnt++;
                    }
                    if (cnt == K) {
                        max = Math.max(max, k - j + 1);
                        min = Math.min(min, k - j + 1);
                        break;
                    }
                }
            }
            if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            System.out.println(min + " " + max);

        }




    }
}