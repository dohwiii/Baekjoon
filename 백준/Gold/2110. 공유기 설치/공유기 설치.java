import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);  // 오름차순 정렬
        int min = home[1] - home[0];        // 최소 인접 거리
        int max = home[N - 1] - home[0];    // 최대 인접 거리


        System.out.println(binarySearch(1, max, home, C));


    }

    private static int binarySearch(int a, int b, int[] home, int C) {
        int dist = 0;

        while (a <= b) {
            int mid = (a + b) / 2;
            int count = 1;
            int lastHome = home[0];

            for (int i = 1; i < home.length; i++) {
                if (home[i] - lastHome >= mid) {
                    count++;
                    lastHome = home[i];
                }
            }
            if (count >= C) {
                dist = mid;
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }
        return dist;
    }

}
