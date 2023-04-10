import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[21];
        int[] S = new int[21];
        boolean[] visited = new boolean[21];

        arr[0] = 1;
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] * i;
        }
        int M = Integer.parseInt(st.nextToken());

        if (M == 1) { //K번째 순열찾기
            long K = Long.parseLong(st.nextToken());

            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (K <= cnt * arr[N - i])
                    {
                        K -= ((cnt - 1) * arr[N - i]);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {
                System.out.print(S[i] + " ");
            }
        } else if (M == 2) {

            long K = 1;
            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (!visited[j]) {
                        cnt++;
                    }
                }
                K = K + cnt * arr[N - i];
                visited[S[i]] = true;
            }
            System.out.println(K);
        }

    }
}