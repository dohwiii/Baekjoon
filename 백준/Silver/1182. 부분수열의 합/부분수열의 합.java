import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0,  0);
        if (S == 0) {
            System.out.println(ans - 1);
        }
        else {
            System.out.println(ans);
        }

    }
    public static void permutation(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }
        permutation(depth + 1, sum + arr[depth]);
        permutation(depth + 1, sum);

    }

}