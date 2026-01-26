import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 집의 개수
        C = Integer.parseInt(st.nextToken());   // 공유기 개수

        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        int a = 0;
        int b = home[N - 1] - home[0];  // 가장 먼 거리

        System.out.println(binarySearch(a, b, home));



    }

    private static int binarySearch(int a, int b, int[] home) {
        int maxLen = 0;

        while (a <= b) {
            int len = (a + b) / 2;
            int count = 1;
            int lastRouter = home[0];

            for (int i = 1; i < N; i++) {
                int diff = home[i] - lastRouter;
                if (diff >= len) {
                    count++;
                    lastRouter = home[i];   // 마지막 집
                }
            }
            if (count >= C) {
                maxLen = len;
                a = len + 1;
            }
            else {
                b = len - 1;
            }
        }
        return maxLen;
    }

}