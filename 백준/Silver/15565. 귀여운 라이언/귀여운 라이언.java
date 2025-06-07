import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int s = 0, e = 0;
        int minLen = 1_000_000;

        while (e < N) {
            if (arr[e] == 1) {  //라이언
                cnt++;
            }
            e++;
            while (cnt >= K) {
                minLen = Math.min(minLen, e - s);
                if (arr[s] == 1) {
                    cnt--;
                }
                s++;
            }

        }
        if (minLen == 1_000_000) {
            System.out.println(-1);
        }
        else {
            System.out.println(minLen);
        }

    }
}