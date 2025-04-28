import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = fr.nextInt();

        while (T-- > 0) {
            int N = fr.nextInt();
            int K = fr.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = fr.nextInt();
            }
            java.util.Arrays.sort(arr);

            int s = 0, e = N - 1;
            int ans = 0;
            int minDiff = Integer.MAX_VALUE;

            while (s < e) {
                int sum = arr[s] + arr[e];
                int diff = Math.abs(K - sum);

                if (diff < minDiff) {
                    minDiff = diff;
                    ans = 1;
                } else if (diff == minDiff) {
                    ans++;
                }

                if (sum < K) {
                    s++;
                } else {
                    e--;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }

    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din = new DataInputStream(System.in);
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1) buffer[0] = -1;
            }
            return buffer[bufferPointer++];
        }
    }
}