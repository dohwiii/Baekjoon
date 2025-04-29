import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        final private int BS = 1 << 16;
        private DataInputStream din = new DataInputStream(System.in);
        private byte[] buffer = new byte[BS];
        private int bufferPointer = 0, bytesRead = 0;

        public int nextInt() throws IOException {
            int c, x = 0;
            do {
                c = din.read();
            } while (c <= ' ');
            boolean neg = (c == '-');
            if (neg) c = din.read();
            for (; c >= '0' && c <= '9'; c = din.read()) {
                x = x * 10 + (c - '0');
            }
            return neg ? -x : x;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int T = fr.nextInt();
        while (T-- > 0) {
            int N = fr.nextInt();
            int M = fr.nextInt();
            int K = fr.nextInt();

            int len = N + M;
            // 누적합 배열
            int[] money = new int[len];
            int total = 0, ans = 0;

            // 1) 원형 마을 입력 + 총합
            for (int i = 0; i < N; i++) {
                int v = fr.nextInt();
                money[i] = v;
                total += v;
            }
            // 2) 뒤에 복제
            for (int i = N; i < len; i++) {
                money[i] = money[i - N];
            }
            // 3) 누적합
            for (int i = 1; i < len; i++) {
                money[i] += money[i - 1];
            }

            // M == N ⇒ 한 번만 검사
            if (N == M) {
                ans = (total < K ? 1 : 0);
            } else {
                // 슬라이딩 윈도우: r = M ... len-1
                for (int r = M; r < len; r++) {
                    if (money[r] - money[r - M] < K) {
                        ans++;
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        // 출력
        System.out.print(sb);
    }
}