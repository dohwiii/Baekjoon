
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //N개의 구간
        int M = Integer.parseInt(st.nextToken());   //M개 연속
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int K = (int) Math.ceil(9 * (double) M / 10);   //K개 이상

        long[] cntArr = new long[1000001];
        boolean isPossible = false;

        for (int i = 0; i < M; i++) {
            cntArr[arr[i]]++;
            if (cntArr[arr[i]] >= K) {
                isPossible = true;
                break;
            }
        }
        for (int i = 1; i < N - M + 1; i++) {
            int end = i + M - 1;
            cntArr[arr[i - 1]]--;   //이전 구간 빼기
            cntArr[arr[end]]++;

            if (cntArr[arr[end]] >= K) {
                isPossible = true;
                break;
            }
        }

        if (!isPossible) {
            for (int i = 0; i < 1000001; i++) {
                if (cntArr[i] == 0) {
                    continue;
                }
                if (cntArr[i] >= K) {
                    isPossible = true;
                    break;
                }
            }
        }

        if (isPossible) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
