import java.io.*;
import java.util.*;

public class Main {
    static int readInt() throws IOException {
        int c, n = System.in.read() & 15; // 첫 숫자 처리
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15); // n * 10 + 숫자
        }
        return n;
    }

    static long readLong() throws IOException {
        int c = System.in.read();
        while (c <= 32) c = System.in.read(); // 공백 넘기기

        long n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        int W = readInt();   // 가로
        int H = readInt();   // 세로
        long K = readLong(); // 최대 조각 크기

        int N = readInt();   // y 커팅 개수
        long[] heights = new long[N + 1];
        int prevY = 0;
        for (int i = 0; i < N; i++) {
            int y = readInt();
            heights[i] = y - prevY;
            prevY = y;
        }
        heights[N] = H - prevY;

        int M = readInt();   // x 커팅 개수
        long[] widths = new long[M + 1];
        int prevX = 0;
        for (int i = 0; i < M; i++) {
            int x = readInt();
            widths[i] = x - prevX;
            prevX = x;
        }
        widths[M] = W - prevX;

        Arrays.sort(widths);
        Arrays.sort(heights);

        int j = heights.length - 1;
        long ans = 0;
        for (int i = 0; i < widths.length; i++) {
            while (j >= 0 && widths[i] * heights[j] > K) {
                j--;
            }
            if (j >= 0) {
                ans += j + 1;
            }
        }

        System.out.println(ans);
    }
}