import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //문자열 S의 길이
        int K = Integer.parseInt(st.nextToken());   //연산의 최대 사용횟수
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int s = 0, e = N - 1;
        //PPC
        while (s < e && K > 0) {
            while (s < N && arr[s] == 'P') {
                s++;
            }
            while (e > 0 && arr[e] == 'C') {
                e--;
            }
            if (s < e) {
                K--;
                arr[s] = 'P';
                arr[e] = 'C';
            }
        }
        long ans = 0;
        long cntP = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                cntP++;
            } else {
                ans += cntP * (cntP - 1) / 2;
            }
        }
        System.out.println(ans);
    }
}