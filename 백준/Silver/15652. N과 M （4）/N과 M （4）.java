import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //1~N까지
        M = Integer.parseInt(st.nextToken()); //M개를 고른 수열
        arr = new int[M];
        permutation(1, 0);
        System.out.println(sb);

    }

    public static void permutation(int index, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i <= N; i++) {
            arr[depth] = i;
            permutation(i, depth + 1);

        }
    }
}
