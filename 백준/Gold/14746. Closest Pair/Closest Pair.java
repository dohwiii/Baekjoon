import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //P 개수
        int M = Integer.parseInt(st.nextToken());   //Q 개수
        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[] P = new int[N];
        int[] Q = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Q[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        Arrays.sort(Q);
        int dist = Math.abs(c1 - c2);
        int s1 = 0, s2 = 0;
        int minDiff = 200_000_000;
        int pair = 0;

        while (s1 < N && s2 < M) {
            int p = P[s1];
            int q = Q[s2];
            int diff = Math.abs(p - q);

            if (minDiff == diff) {
                pair++;
            }
            else if (diff < minDiff) {
                minDiff = diff;
                pair = 1;
            }
            if (p >= q) {
                s2++;
            }
            else if (p < q) {
                s1++;
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist + minDiff + " " + pair);

        System.out.println(sb);


    }
}