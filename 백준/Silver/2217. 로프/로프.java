
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    static List<Integer> weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        weights = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            weights.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(weights, Collections.reverseOrder());

        int w = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int k = i + 1;
            dp[i] = weights.get(i) * k;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);



    }


}