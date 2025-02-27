import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double[] dp = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
            dp[i] = arr[i];
        }

        double max = 0.0;
        for (int i = 1; i < N; i++) {
            double r = dp[i - 1] * arr[i];
            dp[i] = Math.max(dp[i], r);
            max = Math.max(max, dp[i]);
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(String.format("%.3f", max));

    }
}
