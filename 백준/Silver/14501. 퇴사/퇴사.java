import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 2]; //i번째 날부터 퇴사일까지 벌 수 있는 최대 수입
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i > 0; i--) {
            int day = T[i];
            int pay = P[i];

            if (day + i <= N + 1)
            {
                D[i] = Math.max(D[i + 1], D[i + day] + pay);
            }
            else
                D[i] = D[i + 1];
        }


        System.out.println(D[1]);
    }
}