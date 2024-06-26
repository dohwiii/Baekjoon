import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] wage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //일 수
        M = Integer.parseInt(st.nextToken());   //연속 일 수
        wage = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            wage[i] = Integer.parseInt(st.nextToken());
        }

        // m이 0인 경우 일을 하지 않으므로 최대 이익은 0
        if (M == 0) {
            System.out.println(0);
            return;
        }

        long max = 0;
        for (int i = 0; i < M; i++) {
            max += wage[i];
        }
        long temp = max;

        if (N > M) {
            for (int i = 1; i < N - M + 1; i++) {
                int end = i + M - 1;
                temp = temp - wage[i - 1] + wage[end];

                max = Math.max(max, temp);
            }
        }
        System.out.println(max);

    }
}