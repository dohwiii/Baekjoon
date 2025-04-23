import java.io.*;
public class Main {
    static final int MAX = 1_000_000;
    static int[] A = new int[MAX], B = new int[MAX];

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        while (true) {
            int N = in.nextInt();
            int M = in.nextInt();
            if (N == 0 && M == 0) break;

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = in.nextInt();
            }

            int cnt = 0, p1 = 0, p2 = 0;
            while (p1 < N && p2 < M) {
                if (A[p1] == B[p2]) {
                    cnt++; p1++; p2++;
                } else if (A[p1] < B[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }
            out.println(cnt);
        }

        out.flush();
    }

    static class FastReader {
        final int BUF_SIZE = 1<<20;
        DataInputStream in = new DataInputStream(System.in);
        byte[] buf = new byte[BUF_SIZE];
        int bufLen = 0, bufPos = 0;

        int read() throws IOException {
            if (bufPos >= bufLen) {
                bufLen = in.read(buf, 0, BUF_SIZE);
                bufPos = 0;
                if (bufLen == -1) return -1;
            }
            return buf[bufPos++] & 0xFF;
        }

        int nextInt() throws IOException {
            int c, x = 0, sign = 1;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            for (; c >= '0' && c <= '9'; c = read()) {
                x = x * 10 + (c - '0');
            }
            return x * sign;
        }
    }
}