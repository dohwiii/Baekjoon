
import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 집 개수
        C = Integer.parseInt(st.nextToken());   // 공유기 개수
        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);
        System.out.println(binarySearch());

    }

    private static int binarySearch() {
        int s = 0, e = home[N - 1] - home[0];
        int maxDist = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            int wifi = 1;
            int prev = home[0];
            for (int i = 1; i < N; i++) {
                if (home[i] - prev >= mid) {
                    prev = home[i];
                    wifi++;
                }
            }
            if (wifi >= C) {
                maxDist = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return maxDist;
    }


}