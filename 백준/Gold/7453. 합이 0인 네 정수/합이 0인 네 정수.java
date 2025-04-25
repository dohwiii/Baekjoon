import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = fr.nextInt();
        int[] A = new int[n], B = new int[n], C = new int[n], D = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = fr.nextInt();
            B[i] = fr.nextInt();
            C[i] = fr.nextInt();
            D[i] = fr.nextInt();
        }

        int nn = n * n;
        int[] AB = new int[nn];
        int[] CD = new int[nn];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++, idx++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long ans = 0;
        int s = 0, e = nn - 1;
        while (s < nn && e >= 0) {
            long sum = (long)AB[s] + CD[e];
            if (sum == 0) {
                // 중복 값 묶어서 한 번에 더해주기
                long ca = 1, cb = 1;
                int va = AB[s], vc = CD[e];
                s++; e--;
                while (s < nn && AB[s] == va) { ca++; s++; }
                while (e >= 0 && CD[e] == vc) { cb++; e--; }
                ans += ca * cb;
            } else if (sum < 0) {
                s++;
            } else {
                e--;
            }
        }

        bw.write(Long.toString(ans));
        bw.newLine();
        bw.flush();
    }

    // ---------------------------------------
    // FastReader: DataInputStream 기반 매우 빠른 입력기
    // ---------------------------------------
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 20;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufPos, bufLen;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufPos = bufLen = 0;
        }

        public int nextInt() throws IOException {
            int c, x = 0, sign = 1;
            while ((c = read()) <= ' ') {
                if (c == -1) throw new EOFException();
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            do {
                x = x * 10 + (c - '0');
            } while ((c = read()) >= '0' && c <= '9');
            return x * sign;
        }

        private int read() throws IOException {
            if (bufPos >= bufLen) {
                bufLen = din.read(buffer, 0, BUFFER_SIZE);
                bufPos = 0;
                if (bufLen < 0) return -1;
            }
            return buffer[bufPos++] & 0xFF;
        }
    }
}