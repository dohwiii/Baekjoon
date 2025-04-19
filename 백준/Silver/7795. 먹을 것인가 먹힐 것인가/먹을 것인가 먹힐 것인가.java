
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);
            int pair = 0;

            for (int i = 0; i < N; i++) {
                int fish = A[i];
                pair += solve(fish, B, M);

            }
            sb.append(pair + "\n");

        }
        System.out.println(sb.toString());


    }

    public static int solve(int fish, int[] B, int M) {
        int s = 0;
        int e = 0;
        int eat = 0;

        while (e < B.length) {
            if (B[e] >= fish) {
                break;
            } else if (B[e] < fish) {   //잡아먹힘
                e++;
                eat++;
            }
        }
        return eat;
    }

}