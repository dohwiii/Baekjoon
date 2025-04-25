import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();

        int N = fr.nextInt();
        int S = fr.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextInt();
        }

        int left = 0;
        long sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            while (sum >= S) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }

    // 초고속 입력 전용 클래스
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16; // 64KB
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();  // 공백 스킵
            boolean neg = (c == '-');
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg ? -ret : ret;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
            bufferPointer = 0;
        }
    }
}