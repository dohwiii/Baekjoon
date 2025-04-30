import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int M = Integer.parseInt(br.readLine());
            if (M == 0) {
                break;
            }
            String str = br.readLine();
            char[] arr = str.toCharArray();
            int[] cnt = new int[128];
            int distinct = 0;
            int maxLen = 0;
            int s = 0, e = 0;

            while (s < arr.length && e < arr.length) {
                char alp = arr[e];
                if (cnt[alp] > 0) {   //이미 문자열에 포함됐다면
                    cnt[alp]++;
                    e++;
                } else {  //처음 등장
                    if (distinct < M) { //알파벳 추가 가능
                        cnt[alp]++;
                        distinct++;
                        e++;
                    } else {  //추가 불가능
                        cnt[arr[s]]--;
                        if (cnt[arr[s]] == 0) {   //arr[s]의 문자가 다 사라졌다면
                            distinct--;
                        }
                        s++;
                    }
                }
                maxLen = Math.max(maxLen, e - s);
            }
            sb.append(maxLen + "\n");

        }
        System.out.println(sb);


    }
}