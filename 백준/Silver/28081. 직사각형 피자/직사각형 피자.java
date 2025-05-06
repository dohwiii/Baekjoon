import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());   //가로
        int H = Integer.parseInt(st.nextToken());   //세로
        long K = Long.parseLong(st.nextToken());   //최대 K크기까지
        int N = Integer.parseInt(br.readLine());
        int tempW = W, tempH = H;
        long[] widths = new long[N + 1];   //가로 (y)
        st = new StringTokenizer(br.readLine());
        int prevW = 0;
        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(st.nextToken());
            widths[i] = w - prevW;
            prevW = w;
        }
        widths[N] = H - prevW;
        int M = Integer.parseInt(br.readLine());
        long[] heights = new long[M + 1];  //세로 (x)
        st = new StringTokenizer(br.readLine());
        int prevH = 0;
        for (int i = 0; i < M; i++) {
            int h = Integer.parseInt(st.nextToken());
            heights[i] = h - prevH;
            prevH = h;
        }
        heights[M] = W - prevH;
        Arrays.sort(widths);
        Arrays.sort(heights);

        int j = M;
        long ans = 0;
        for (int i = 0; i <= N; i++) {
            while (j >= 0 && 1L * widths[i] * heights[j] > K) {
                j--;
            }
            if (j >= 0) {
                ans += (j + 1);
            }

        }
        System.out.println(ans);


    }

}